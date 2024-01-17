package net.developia.todolist

import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.LinearLayoutManager
import net.developia.todolist.databinding.ActivityMainBinding
import net.developia.todolist.db.AppDatabase
import net.developia.todolist.db.ToDoDao
import net.developia.todolist.db.ToDoEntity

class MainActivity : AppCompatActivity(), OnItemLongClickListener, OnItemClickListener {

    //뷰 바인딩 설정
    private lateinit var binding: ActivityMainBinding

    //데이터 관련 변수를 선언, 할 일 리스트를 담아둘 todoList를 선언합니다.
    private lateinit var db: AppDatabase
    private lateinit var todoDao: ToDoDao
    private lateinit var todoList: ArrayList<ToDoEntity>

    //리사이클러뷰 어댑터 변수 선언
    private lateinit var adapter: TodoRecyclerViewAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //인텐트를 사용해 다음 액티비티로 넘어가는 리스너를 구현합니다.
        binding.btnAdd.setOnClickListener {
            val intent = Intent(this, AddToDoActivity::class.java)
            startActivity(intent)
        }

        //DB 인스턴스를 가져오고 DB 작업을 할 수 있는 DAO를 가져옵니다.
        db = AppDatabase.getInstance(this)!!
        todoDao = db.getTodoDao()

        getAllTodoList()
    }

    //백그라운드 스레드에서 DB 관련 작업을 해줌니다.
    private fun getAllTodoList() {
        //DB에서 할 일 목록을 가져옵니다.
        Thread {
            todoList = ArrayList(todoDao.getAll())
            setRecyclerView()
        }.start()
    }


    private fun setRecyclerView() {
        //리사이클러뷰 설정
        // setRecyclerView()함수를 부르는 곳이 getAllTodoList()인데
        // 이 함수가 백그라운드 스레드에서 실행되기 때
        runOnUiThread{
            adapter = TodoRecyclerViewAdapter(todoList, this,this) // 어댑터 객체 할당
            binding.recyclerView.adapter = adapter
            // 리사이클러뷰 어댑터로 위에서 만든 어댑터 설정
            binding.recyclerView.layoutManager = LinearLayoutManager(this)
            // 레이아웃 매니저 설정
        }
    }

    //getAllTodoList()를 작동시켜 새롭게 할 일 리스트 데이터를 갱신시켜줌
    // AddToDoActivity에서 돌아왔을 때, 새로운 할 일이 추가되었을 때, 화면이 다시 보일 때
    override fun onRestart(){
        super.onRestart()
        getAllTodoList()
    }

    //OnItemLongClickListener 인터페이스의 onLongClick() 함수를 구현
    override fun onLongClick(position: Int) {
        val builder: AlertDialog.Builder = AlertDialog.Builder(this)
        builder.setTitle("할 일 삭제")
        builder.setMessage("정말 삭제하시겠습니까?")
        builder.setNegativeButton("아니요", null)
        builder.setPositiveButton("네",
            object : DialogInterface.OnClickListener {
                override fun onClick(dialog: DialogInterface?, p1: Int) {
                    deleteTodo(position)
                }
            }
        )
        builder.show()
    }

    private fun deleteTodo(position: Int) {
        Thread {
            todoDao.deleteTodo(todoList[position])
            todoList.removeAt(position)
            runOnUiThread {
                adapter.notifyDataSetChanged()
                Toast.makeText(this, "할 일이 삭제되었습니다.",
                    Toast.LENGTH_SHORT).show()
            }
        }.start()
    }

    override fun onClick(position: Int) {
        val builder: AlertDialog.Builder = AlertDialog.Builder(this)
        builder.setTitle("할 일 수정")
        builder.setMessage("정말 수정하시겠습니까?")
        builder.setNegativeButton("아니요", null)
        builder.setPositiveButton("네",
            object : DialogInterface.OnClickListener {
                override fun onClick(p0: DialogInterface?, p1: Int) {
                    updateTodo(position)
                }
            }
        )
        builder.show()
    }

    private fun updateTodo (position: Int) {
        val intent = Intent(applicationContext, UpdateToDoActivity::class.java)
        intent.putExtra("id", todoList[position].id)
        intent.putExtra("title", todoList[position].title)
        intent.putExtra("importance", todoList[position].importance)
        startActivity(intent)
    }

}