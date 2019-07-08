package com.example.architecturedemo.ui.main

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.*
import com.example.architecturedemo.R
import kotlinx.android.synthetic.main.main_fragment.*

class MainFragment : Fragment(), Observer<User>, LifecycleObserver {
    companion object {

        fun newInstance() = MainFragment()
    }
    private lateinit var viewModel: MainViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.main_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)
        Log.e(
            "MainFragment",
            "videomodel is $viewModel new viewModel is ${ViewModelProviders.of(this).get(MainViewModel::class.java)}"
        )
//        viewModel.getUserInfo().observe(this,this)

//        viewModel.getUserInfo().observeForever(this)
        lifecycle.addObserver(this)
        viewModel.registerObserver(this)

        message.setOnClickListener {
            viewModel.setUserInfo(User("zlw",26))
        }
    }

    @SuppressLint("SetTextI18n")
    private fun updateUI(user: User) {
        message.text = "name = ${user.name} age = ${user.age}"

    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    fun onFragmentDestroy() {
        Log.e("MainFragment","移除观察者")
        viewModel.unregisterObserver(this)
    }

    override fun onChanged(t: User) {
        updateUI(t)
    }

}
