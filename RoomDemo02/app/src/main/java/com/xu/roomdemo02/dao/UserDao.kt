package com.xu.roomdemo02.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.xu.roomdemo02.entity.User

@Dao
interface UserDao {

    @Query("select * from User")
    fun getAllUser() : List<User>

    @Insert
    fun addUser(user: User)

    @Query("delete from User where userName = :name")
    fun deleteUserByName(name: String)

}