package com.xu.roomdemo02.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class User(@ColumnInfo() var userName: String, @ColumnInfo() var age: Int) {

    @PrimaryKey(autoGenerate = true)
    var id : Long = 0

}
