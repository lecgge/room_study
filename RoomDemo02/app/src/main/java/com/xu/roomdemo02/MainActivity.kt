package com.xu.roomdemo02

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.xu.roomdemo02.database.MyDatabase
import com.xu.roomdemo02.databinding.ActivityMainBinding
import com.xu.roomdemo02.entity.User
import kotlin.concurrent.thread

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var dao = MyDatabase.getInstance(baseContext).getDao()

        binding.addUser.setOnClickListener {
            thread {
                dao.addUser(User("张三",18))
                dao.addUser(User("李四",19))
                dao.addUser(User("王五",20))
            }
        }


        binding.queryUser.setOnClickListener {
            thread {
                var allUser = dao.getAllUser()
                for (user in allUser) {
                    Log.d("TAG", "onCreate: + " + user)
                }
                Log.d("TAG", "onCreate: ----------------------------")
            }
        }


        binding.deleteuser.setOnClickListener {
            thread {
                dao.deleteUserByName("张三")
                var allUser = dao.getAllUser()

            }
        }
    }
}