package com.xu.roomdemo01.database

import android.content.Context
import androidx.room.*
import androidx.sqlite.db.SupportSQLiteOpenHelper
import com.xu.roomdemo01.dao.UserDao
import com.xu.roomdemo01.entity.User

//使用Database注解，声明数据库版本号及包含了哪些实体类
/*
* exportSchema：这个字段默认为true，它会导出一个json文件，
* 包含了数据库在升级或者操作数据表时候的所有的操作，
* 也包含了所有表中的字段，
* 以及字段的描述生成到项目的目录下()需要配置
* */
@Database(version = 1, entities = [User::class], exportSchema = true)
abstract class AppDataBase : RoomDatabase() {

    abstract fun userDao() : UserDao

    companion object {
        private var instance: AppDataBase? = null

        @Synchronized
        fun getDataBase(context: Context): AppDataBase {
            //当instance不为空时直接返回instance，否则创建AppDataBase实例并返回
            instance?.let {
                return it
            }

            return Room.databaseBuilder(context.applicationContext,
            AppDataBase::class.java,"app_database").allowMainThreadQueries().build().apply {
                instance = this
            }
        }
    }
}