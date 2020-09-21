package com.example.recyclerviewdemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.viewModels
import androidx.collection.arraySetOf
import androidx.core.text.PrecomputedTextCompat
import androidx.core.widget.TextViewCompat
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.*
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.ViewModel
import androidx.lifecycle.coroutineScope
import androidx.lifecycle.lifecycleScope
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_layout.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import kotlin.coroutines.CoroutineContext

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val combinedArraySet = arraySetOf(1, 2, 3) + arraySetOf(4, 5, 6)
        println("combi ${combinedArraySet}")


        supportFragmentManager.commit {
            addToBackStack("...")
            setCustomAnimations(R.anim.fragment_open_enter, R.anim.fragment_close_exit)
            add(root.id, MyFragment(), "...")

        }
    }
}

class MyViewModel : ViewModel() {

}

class MyFragment : Fragment() {
    val viewModel by activityViewModels<MyViewModel>()
    val viewModel2 by viewModels<MyViewModel>()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_layout, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Toast.makeText(view.context, "12k34jkl123j4k ", Toast.LENGTH_SHORT).show()
        lifecycleScope.launch {
            val params = TextViewCompat.getTextMetricsParams(tv)
            val precomputedText = withContext(Dispatchers.IO) {
                Log.e("MyFragment","onViewCreated ${Thread.currentThread().name}")

                PrecomputedTextCompat.create("askfjask爱上的咖啡就爱adsf阿斯顿发送到看楼上的附近拉斯疯狂拉升发啦", params)
            }
            TextViewCompat.setPrecomputedText(tv, precomputedText)
        }
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
    }
}