package com.xu.roomdemo01

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.LinearLayout
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.xu.roomdemo01.database.AppDataBase
import com.xu.roomdemo01.databinding.ActivityMainBinding
import com.xu.roomdemo01.entity.User
import java.text.Bidi
import kotlin.concurrent.thread

class MainActivity : AppCompatActivity() {
    var list = ArrayList<User>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerview)
        val manager = LinearLayoutManager(this)
        manager.orientation = RecyclerView.VERTICAL
        recyclerView.layoutManager = manager
        recyclerView.adapter = MyAdapter(this, list)


        var userList = arrayListOf<User>(User("Tom", "Brady", 40),
            User("Tom", "Hanks", 63),
            User("Hami", "Hanks", 52))

        val viewModel = ViewModelProviders.of(this).get(MainActivityViewModel::class.java)
        viewModel.listUser.observe(this, Observer {
            for (user in it) {
                Log.d("TAG", "onCreate: ++"+user)
            }
            if (it.size == 0) {
                Log.d("TAG", "onCreate: True")
            }
            list.clear()
            list.addAll(it)
            recyclerView.adapter = MyAdapter(this, list)
        })

        val userDao = viewModel.appDataBase.userDao()


        val addDataBtn = findViewById<Button>(R.id.addDataBtn)
        addDataBtn.setOnClickListener {
            thread {
                for (user in userList) {
                    userDao.insertUser(user)
                }
            }
        }
        val updateDataBtn = findViewById<Button>(R.id.updateDataBtn)
        updateDataBtn.setOnClickListener {
            thread {
                list[0].age = 42
                userDao.updateUser(list[0])
            }
        }
        val deleteDataBtn = findViewById<Button>(R.id.deleteDataBtn)
        deleteDataBtn.setOnClickListener {
            thread {
                userDao.deleteUserByFirstName("Hami")
            }
        }
        val queryDataBtn = findViewById<Button>(R.id.deleteDataBtn)
        queryDataBtn.setOnClickListener {
            thread {
                list.addAll(userDao.loadAllUsers().value!!)
            }
        }

        val  getUserBtn = findViewById<Button>(R.id.deleteDataBtn)
        getUserBtn.setOnClickListener {
            thread {
                userDao.deleteAll()
            }
        }
    }
}