package net.developia.todolist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import net.developia.todolist.databinding.ActivityAddToDoBinding
import net.developia.todolist.db.AppDatabase
import net.developia.todolist.db.ToDoDao
import net.developia.todolist.db.ToDoEntity

class AddToDoActivity : AppCompatActivity() {

    lateinit var binding: ActivityAddToDoBinding
    lateinit var db: AppDatabase
    lateinit var todoDao: ToDoDao

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityAddToDoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        db = AppDatabase.getInstance(this)!!
        todoDao = db.getTodoDao()

        binding.btnCompletion.setOnClickListener {
            insertTodo()
        }
    }

    private fun insertTodo() {
        val todoTitle = binding.edtTitle.text.toString() //할일의 제목
        var todoImportance = binding.radioGroup.checkedRadioButtonId //할일의 중요도

        //어떤 버튼이 눌렸는지 확인하고 값을 지정해줍니다.
        when(todoImportance){
            R.id.btn_high -> {
                todoImportance = 1
            }
            R.id.btn_middle -> {
                todoImportance = 2
            }
            R.id.btn_low -> {
                todoImportance = 3
            }

            else -> {
                todoImportance = -1
            }
        }

        //중요도가 선택되지 않거나, 제목이 작성되지 않는지 체크합니다.
        if(todoImportance == -1 || todoTitle.isBlank()){
            Toast.makeText(this, "모든 항목을 채워주세요.",
                Toast.LENGTH_SHORT).show()
        } else {
            Thread {
                todoDao.insertTodo(
                    ToDoEntity(
                        null,
                        todoTitle,
                        todoImportance
                    )
                )
                runOnUiThread { // 아래 작업은 메인스레드에서 실행해야 합니다.
                    Toast.makeText(this, "할일이 추가되었습니다.",
                        Toast.LENGTH_SHORT).show()
                    finish() // AddToDoActivity 종료, 다시 MainActivity로 돌아갑니다.
                }
            }.start()
        }
    }
}