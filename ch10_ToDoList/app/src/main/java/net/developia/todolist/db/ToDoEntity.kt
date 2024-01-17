package net.developia.todolist.db

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "ToDoEntity")
data class ToDoEntity (
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id") var id: Int? = null,
    @NonNull @ColumnInfo(name = "title") var title: String,
    @NonNull @ColumnInfo(name = "importance") var importance: Int
)