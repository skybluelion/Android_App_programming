package net.developia.todolist.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

//1 어노테이션으로 데이터베이스임을 명시, 앤터티들을 콤마로 구분해 나령하고, 현재 db 버전 명시
@Database(entities = arrayOf(ToDoEntity::class), version = 1)
//2 RoomDatabase를 상속받는 추상 클래스
abstract class AppDatabase : RoomDatabase() {
    //3 DAO를 반환하는 추상 메서드
    abstract fun getTodoDao(): ToDoDao

    //4 appDatabase가 null이면 Room.databaseBuilder()를 통해 데이터베이스를 생성하고
    // null이 아니면 객체를 반환하는 싱글톤 패턴 getInstance() 메서드
    companion object {
        val databaseName = "db_todo"
        var appDatabase : AppDatabase? = null

        fun getInstance(context : Context) : AppDatabase? {
            if(appDatabase == null) {
                appDatabase = Room.databaseBuilder(context,
                    AppDatabase::class.java, databaseName).build()
            }
            return appDatabase
        }
    }
}
