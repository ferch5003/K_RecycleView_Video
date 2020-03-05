package com.uninorte.k_recycleview_video

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.uninorte.k_recycleview_video.data.RandomUser

class RandomUserViewModel(application: Application) : AndroidViewModel(application) {

    private var randomUserDao: RandomUserDao

    init{
        randomUserDao = RandomUserDao.getInstance(this.getApplication())
    }

    fun addUsers() {
        randomUserDao.addUsers()
    }

    fun addUser(gender: String?) {
        randomUserDao.addUser(gender)
    }


    fun getUsers(): MutableLiveData<List<RandomUser>>{
        return randomUserDao.getUsers()
    }
}