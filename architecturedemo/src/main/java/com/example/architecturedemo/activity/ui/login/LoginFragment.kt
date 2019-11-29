package com.example.architecturedemo.activity.ui.login

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavArgument
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.architecturedemo.R
import kotlinx.android.synthetic.main.login_fragment.*

class LoginFragment : Fragment() {

    companion object {
        fun newInstance() = LoginFragment()
        val TAG = LoginFragment::class.simpleName
    }

    private lateinit var viewModel: LoginViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.login_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(LoginViewModel::class.java)
        // TODO: Use the ViewModel
//        val arg by navArgs<LoginFragmentArgs>()
        message.text  = TAG + " ${arguments?.getString("name")}"

        message.setOnClickListener {
            findNavController().navigate(LoginFragmentDirections.actionLoginFragmentToRegisterFragment())
        }
    }

}
