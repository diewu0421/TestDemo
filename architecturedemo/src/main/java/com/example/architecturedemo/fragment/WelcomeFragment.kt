package com.example.architecturedemo.fragment

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavDirections
import androidx.navigation.fragment.findNavController
import androidx.navigation.navOptions
import com.example.architecturedemo.R

class WelcomeFragment : Fragment() {

    private var mViewModel: WelcomeViewModel? = null

    private var mRootView: View? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mRootView = inflater.inflate(R.layout.welcome_fragment, container, false)
        return mRootView
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        mViewModel = ViewModelProviders.of(this).get(WelcomeViewModel::class.java)
        // TODO: Use the ViewModel

        mRootView!!.findViewById<View>(R.id.login_btn)
            .setOnClickListener {
//                val navDirections = WelcomeFragmentDirections.actionWelcomeFragmentToLoginFragment()

//                navDirections.name = "我是曾令文"
//                findNavController().navigate(navDirections)
                val navOption = navOptions {
                    anim {
                        enter = R.anim.slide_in_right
                        exit = R.anim.slide_out_left
                        popEnter = R.anim.slide_in_left
                        popExit = R.anim.slide_out_right
                    }
                }
                findNavController().navigate(R.id.loginFragment, Bundle().apply {

                    putString("name","我是曾令文11111111111")
                },navOption)
            }
    }

    companion object {
        fun newInstance(): WelcomeFragment {
            return WelcomeFragment()
        }
    }

}
