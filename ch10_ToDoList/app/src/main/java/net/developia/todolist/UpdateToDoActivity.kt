package net.developia.todolist

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import net.developia.todolist.databinding.ActivityUpdateToDoBinding
import net.developia.todolist.db.AppDatabase
import net.developia.todolist.db.ToDoDao
import net.developia.todolist.db.ToDoEntity

class UpdateToDoActivity : AppCompatActivity() {

    private lateinit var binding: ActivityUpdateToDoBinding
    lateinit var db: AppDatabase
    lateinit var todoDao: ToDoDao

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityUpdateToDoBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val intent = intent
        binding.id.text = intent.getIntExtra("id", 1).toString()
        binding.edtTitle.setText(intent.getStringExtra("title"))
        var importance = intent.getIntExtra("importance", 1)
        when (importance) {
            1 -> {
                binding.btnHigh.isChecked = true
            }
            2 -> {
                binding.btnMiddle.isChecked = true
            }
            3 -> {
                binding.btnLow.isChecked = true
            }
        }


        db = AppDatabase.getInstance(this)!!
        todoDao = db.getTodoDao()

        binding.btnComplete.setOnClickListener {
            updateTodo()
        }
    }

    private fun updateTodo() {
        var todoId:Int = binding.id.text.toString().toInt()
        val todoTitle = binding.edtTitle.text.toString() //할일의 제목
        var todoImportance = binding.radioGroup.checkedRadioButtonId //할일의 중요도

        var impData = 0
        //어떤 버튼이 눌렸는지 확인하고 값을 지정해줍니다.
        when(todoImportance){
            R.id.btn_high -> {
                impData = 1
            }
            R.id.btn_middle -> {
                impData = 2
            }
            R.id.btn_low -> {
                impData = 3
            }
        }

        //중요도가 선택되지 않거나, 제목이 작성되지 않는지 체크합니다.
        if(impData == -1 || todoTitle.isBlank()){
            Toast.makeText(this, "모든 항목을 채워주세요.",
                Toast.LENGTH_SHORT).show()
        } else {
            Thread {
                todoDao.update(
                    ToDoEntity(
                        todoId,
                        todoTitle,
                        impData
                    )
                )
                runOnUiThread { // 아래 작업은 메인스레드에서 실행해야 합니다.
                    Toast.makeText(this, "할일이 수정되었습니다.",
                        Toast.LENGTH_SHORT).show()
                    finish() // AddToDoActivity 종료, 다시 MainActivity로 돌아갑니다.
                }
            }.start()
        }
    }

}