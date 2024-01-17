package net.developia.todolist.db

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface ToDoDao {
    @Query("SELECT id, title, importance FROM ToDoEntity")
    fun getAll() : List<ToDoEntity>

    @Insert // convenience annotation
    fun insertTodo(todo: ToDoEntity)

    @Delete
    fun deleteTodo(todo: ToDoEntity)

    @Update
    fun update(todo: ToDoEntity)
}