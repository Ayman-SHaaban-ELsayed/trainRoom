package com.ayman.roomdatabasetraining.data

import androidx.room.Entity
import androidx.room.PrimaryKey

//    @PrimaryKey val uid: Int,
@Entity(tableName = "user_table")
data class User(
    @PrimaryKey(autoGenerate = true) val id: Int,
    val FirstName: String,
    val LastName: String,
    val age: Int
)
