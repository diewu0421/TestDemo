package com.example.architecturedemo.fragment

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer

import com.example.architecturedemo.R
import kotlinx.android.synthetic.main.room_fragment.*

class RoomFragment : Fragment() {

    companion object {
        fun newInstance() = RoomFragment()
    }

    private lateinit var viewModel: RoomViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.room_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(RoomViewModel::class.java)
        login.setOnClickListener {
            this@RoomFragment.context?.let { it1 -> viewModel.setContext(it1) }
            viewModel.getLoginInfo("diewu0421")?.observe(this, Observer {
                Log.e("RoomFragment","it = $it")
            })
        }

        register.setOnClickListener {
            this@RoomFragment.context?.let { viewModel.setContext(it)}

            viewModel.saveLoginInfo("diewu0421", "buzhidao")
        }
    }

}
