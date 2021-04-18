package com.ayman.roomdatabasetraining

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.LiveData
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.room.Room
import com.ayman.roomdatabasetraining.data.User
import com.ayman.roomdatabasetraining.data.UserDatabase

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
setupActionBarWithNavController(findNavController(R.id.fragment))

//        val db = Room.databaseBuilder(
//            applicationContext,
//            UserDatabase::class.java, "database-name"
//        ).build()
//
//        val userDao = db.userDao()
//        val users: LiveData<List<User>> = userDao.readAllData()
// another trick   val users2: List<User> = userDao.readAllData2()

    }

    override fun onSupportNavigateUp(): Boolean {
        val navController=findNavController(R.id.fragment)
        return navController.navigateUp()||super.onSupportNavigateUp()
    }
}