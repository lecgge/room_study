package com.xu.roomdemo02.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.xu.roomdemo02.entity.Book

@Dao
interface BookDao {

    @Insert
    public fun insertBook(book: Book)

    @Query("select * from Book")
    fun loadAllBook():List<Book>
}