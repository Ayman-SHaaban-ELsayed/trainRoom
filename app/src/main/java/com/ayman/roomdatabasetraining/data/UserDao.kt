package com.ayman.roomdatabasetraining.data

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface UserDao {
    @Query("SELECT * FROM user_table ORDER BY id ASC")
    fun readAllData(): LiveData<List<User>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addUser(user: User)

    //todo Another Tricks
    @Query("SELECT * FROM user_table ORDER BY id ASC")
    fun readAllData2(): List<User>

    @Query("SELECT * FROM user_table WHERE id IN (:userIds)")
    fun loadAllByIds(userIds: IntArray): List<User>

    @Query(
        "SELECT * FROM user_table WHERE FirstName LIKE :first AND " +
                "LastName LIKE :last LIMIT 1"
    )
    fun findByName(first: String, last: String): User

    @Insert
    fun insertAll(vararg users: User)

    @Delete
    fun delete(user: User)
}