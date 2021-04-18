package com.ayman.roomdatabasetraining.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
@Database(entities =[User::class], version = 1,exportSchema = false)
abstract class UserDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao

    companion object {
        @Volatile
        private var INSTANSE: UserDatabase? = null
        fun getDatabase(context: Context): UserDatabase {
            val tempInstance = INSTANSE
            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this)
            {
                val currentInstance= Room.databaseBuilder(
                    context.applicationContext,
                    UserDatabase::class.java,
                    "user_database"
                ).build()
                INSTANSE=currentInstance
                return currentInstance
            }
        }
    }
}