package com.xu.roomdemo02.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase
import com.xu.roomdemo02.dao.BookDao
import com.xu.roomdemo02.dao.UserDao
import com.xu.roomdemo02.entity.Book
import com.xu.roomdemo02.entity.User

@Database(version = 3, entities = [User::class, Book::class])
abstract class MyDatabase : RoomDatabase() {

    abstract fun getDao() : UserDao
    abstract fun getBookDao() : BookDao


    companion object {

        val MiGRATION_1_2 = object : Migration(1, 2) {
            override fun migrate(database: SupportSQLiteDatabase) {
                database.execSQL("create table Book (id integer primary key autoincrement not null," +
                        "name text not null," +
                        "pages integer not null)")
            }
        }

        val MiGRATION_2_3 = object : Migration(2, 3) {
            override fun migrate(database: SupportSQLiteDatabase) {
                database.execSQL("alter table Book add column author text not null default 'unknow'")
            }
        }

        val MIGRATION_3_4 = object : Migration(3, 4) {
            override fun migrate(database: SupportSQLiteDatabase) {
                database.execSQL("create table UserBuyBook (userId integer not null,bookId integer not null,money integer not null," +
                        "primary key(userId,bookId))")
            }
        }

        private var instance: MyDatabase? = null

        @Synchronized
        public fun getInstance(context: Context) : MyDatabase {
            instance?.let {
                return it
            }

            return Room.databaseBuilder(context,MyDatabase::class.java,"my_database")
                .addMigrations(MiGRATION_1_2,MiGRATION_2_3, MIGRATION_3_4).build().apply {
                instance = this
            }
        }
    }



}