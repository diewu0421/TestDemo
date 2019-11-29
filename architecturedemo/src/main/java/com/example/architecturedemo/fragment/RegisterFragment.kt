package com.example.architecturedemo.fragment

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.ObservableField

import com.example.architecturedemo.R
import com.example.architecturedemo.databinding.RegisterFragmentBinding
import kotlinx.android.synthetic.main.register_fragment.*

class RegisterFragment : Fragment() {

    companion object {
        fun newInstance() = RegisterFragment()
    }

    private lateinit var viewModel: RegisterViewModel

    private lateinit var binding:RegisterFragmentBinding

    private val name by lazy { ObservableField<String>("我是注册页面")}

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
//        return inflater.inflate(R.layout.register_fragment, container, false)
        binding = RegisterFragmentBinding.inflate(inflater)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(RegisterViewModel::class.java)
        // TODO: Use the ViewModel
        binding.name = name
        binding.root.postDelayed({
            name.set("我要换名字了")
        }, 500)

//        db_test_view.setOnClickListener {
//            db_test_view.printBgColor()
//        }


    }

}
