package com.xu.roomdemo01

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.xu.roomdemo01.database.AppDataBase
import com.xu.roomdemo01.entity.User

class MainActivityViewModel : ViewModel() {

    var appDataBase: AppDataBase = AppDataBase.getDataBase(AppContext.context)
    var listUser : LiveData<List<User>> = appDataBase.userDao().loadAllUsers()



    public fun getLiveDataStudent(): LiveData<List<User>> {
        return listUser
    }




}