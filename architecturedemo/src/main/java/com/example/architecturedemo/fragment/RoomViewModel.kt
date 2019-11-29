package com.example.architecturedemo.fragment

import android.content.Context
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel;
import androidx.room.Room
import com.example.architecturedemo.entity.AppDataBase
import com.example.architecturedemo.entity.LoginInfo
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class RoomViewModel() : ViewModel() {

    val loginInfos = MutableLiveData<List<LoginInfo>>()

    private var roomResposity: RoomResposity? = null

    private var context: Context? = null
    fun setContext(context: Context) {
        this.context = context
    }

    fun getLoginInfo(name: String): LiveData<LoginInfo>? {
        if (roomResposity == null) {

            roomResposity = RoomResposity(context)
        }
        return roomResposity?.getLoginInfo(name)
    }

    fun saveLoginInfo(name: String, pass: String) {
        if (roomResposity == null) {
            roomResposity = RoomResposity(context)
        }

        viewModelScope.launch {
            Log.e("RoomViewModel","thread = ${Thread.currentThread().name}")
            roomResposity?.saveLoginInfo(context, name, pass)
        }

    }


}

class RoomResposity(val context: Context?) {

    fun getLoginInfo(name: String) =

        context?.let {
            Room.databaseBuilder(it, AppDataBase::class.java, "login_db")
                .build()
                .loginDao()
                .getLoginInfo(name)
        }

    suspend fun saveLoginInfo(context: Context?, name: String, pass: String) {

        context?.let {

            withContext(IO) {
                Log.e("RoomResposity","thread = ${Thread.currentThread().name}")
                Room.databaseBuilder(it, AppDataBase::class.java, "login_db")
                    .build()
                    .loginDao()
                    .insertLogin(LoginInfo(name, pass))
            }

        }
    }

}
