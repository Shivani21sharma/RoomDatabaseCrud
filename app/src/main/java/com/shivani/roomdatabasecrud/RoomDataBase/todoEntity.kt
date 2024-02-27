package com.shivani.roomdatabasecrud.RoomDataBase

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class TodoEntity(
    @PrimaryKey
    var id: Int = 0,
    var title : String?= null
)
