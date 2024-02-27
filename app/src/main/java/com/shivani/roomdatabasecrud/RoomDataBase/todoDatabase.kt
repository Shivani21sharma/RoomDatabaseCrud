package com.shivani.roomdatabasecrud.RoomDataBase

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.shivani.roomdatabasecrud.R
import androidx.room.Database as Database1

@Database
abstract class TodoDatabase: RoomDatabase() {
    abstract fun todoDao(): todoDao

    companion object{
        var todoDatabase : TodoDatabase ?= null
        @Synchronized
        fun getDatabaseInstance(context: Context) : TodoDatabase {
            if(todoDatabase == null){
                todoDatabase = Room.databaseBuilder(context,
                    TodoDatabase::class.java,
                    context.resources.getString(R.string.app_name))
                    .allowMainThreadQueries()
                    .build()
            }
            return todoDatabase!!
        }

}





