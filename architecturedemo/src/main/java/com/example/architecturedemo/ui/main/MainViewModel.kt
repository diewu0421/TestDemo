package com.example.architecturedemo.ui.main

import android.util.Log
import androidx.lifecycle.*

class MainViewModel : ViewModel() {
    // TODO: Implement the ViewModel

    private val mLiveData = MutableLiveData<User>()


    fun getUserInfo(): LiveData<User> {

        return Transformations.switchMap(mLiveData) {
            val tempLiveData = MutableLiveData<User>()
//            tempLiveData.value = User(it, 26)
            tempLiveData.value = it
            tempLiveData
        }
    }

    fun setUserInfo(name: User) {
        mLiveData.value = name
    }

    fun registerObserver(observer: Observer<User>) {
        mLiveData.observeForever(observer)
    }

    fun unregisterObserver(observer: Observer<User>) {
        mLiveData.removeObserver(observer)
    }

    override fun onCleared() {
        super.onCleared()
        Log.e("MainViewModel","onCleared")
    }

}

data class User(val name: String, val age: Int)

