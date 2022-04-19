package com.xu.roomdemo01.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

//使用注解将类设置为entity
@Entity
data class User(var firstName: String, var lastName: String, var age: Int) {

    //主键 自增
    @PrimaryKey(autoGenerate = true)
    var id: Long = 0

    
    override fun toString(): String {
        return "User(firstName='$firstName', lastName='$lastName', age=$age, id=$id)"
    }


}