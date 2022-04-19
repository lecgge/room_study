package com.xu.roomdemo02.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Book(var name: String, var pages: Int,var author : String) {

    @PrimaryKey(autoGenerate = true)
    var id :Long = 0
}
