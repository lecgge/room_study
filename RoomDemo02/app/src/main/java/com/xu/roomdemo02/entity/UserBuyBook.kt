package com.xu.roomdemo02.entity

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(
    primaryKeys = arrayOf("userId","bookId"),
    foreignKeys = [ForeignKey(entity = User::class, childColumns = ["userId"], parentColumns = ["id"]),
                        ForeignKey(entity = Book::class, childColumns = ["id"], parentColumns = ["bookId"])
])
class UserBuyBook(var userId: Long, var bookId: Long, var money: Int) {

}