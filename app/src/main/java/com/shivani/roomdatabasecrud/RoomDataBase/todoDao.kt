package com.shivani.roomdatabasecrud.RoomDataBase

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface todoDao {
    @Insert
    fun insertTodo(todoEntity: TodoEntity)
    @Query("Select * from TodoEntity")
    fun getTodoEntities() : List<TodoEntity>
    @Update
    fun UpdateTodo (todoEntity: TodoEntity)
    @Delete
    fun Delete(todoEntity: TodoEntity)

}