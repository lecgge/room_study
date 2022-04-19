package com.xu.roomdemo01.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.xu.roomdemo01.entity.User


@Dao
interface UserDao {

    @Insert
    fun insertUser(user: User): Long //返回User的ID

    @Update(onConflict = OnConflictStrategy.IGNORE)
    fun updateUser(newUser: User)

    @Query("select * from User")
    fun loadAllUsers(): LiveData<List<User>>

    @Query("select * from User where age > :age")
    fun loadUserOlderThan(age: Int): List<User> //传入参数方法 :参数名


    @Query("delete from User where id in :list.id")
    fun deleteAll(list : List<User>)


    @Delete
    fun delete(user: User)

    @Query("delete from User where lastName = :lastName")//Query注解中可以传入任何Sql语句
    fun deleteUserByLastName(lastName: String): Int

    @Query("delete from User where firstName = :firstName")
    fun deleteUserByFirstName(firstName: String): Int



}