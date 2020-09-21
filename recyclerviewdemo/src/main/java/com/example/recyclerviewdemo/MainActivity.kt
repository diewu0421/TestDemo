package com.example.recyclerviewdemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.PrecomputedText
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.widget.AppCompatTextView
import androidx.collection.arraySetOf
import androidx.core.text.PrecomputedTextCompat
import androidx.core.widget.TextViewCompat
import androidx.fragment.app.*
import androidx.lifecycle.*
import io.reactivex.rxjava3.core.Flowable
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_layout.*
import kotlinx.coroutines.*


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

//    val liveData: LiveData<String>  = liveData {
//        LiveDataReactiveStreams.fromPublisher(Flowable.just("你爱上对方"))
//    }


    fun test() {

    }

    fun getUsersLiveData() : LiveData<String> {
        return LiveDataReactiveStreams.fromPublisher(Flowable.just("奥斯卡了房间看来"))
    }
}

suspend fun getString(): String {
    return "nihao"

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
//            val precomputedText = withContext(Dispatchers.IO) {
//
//                val pre: PrecomputedTextCompat
//                val mill = measureTimeMillis {
//
//                    pre = PrecomputedTextCompat.create("asdfasdf", params)
//                }
//
//                Log.e("MyFragment","onViewCreated ${Thread.currentThread().name} start = $mill")
//
//                pre
//            }
//            TextViewCompat.setPrecomputedText(tv, precomputedText)
            tv.setTextFuture("aklajfkla俺是快乐的金发蓝色的付款啦时间的福利卡时记得付款了;驾驶的快乐;发牢骚的空间付款啦;按时来了即可拉伸的就付款啦就是考虑对方")
        }

        viewModel.getUsersLiveData().observeForever {
            Log.e("MyFragment","onViewCreated observeForever $it")
        }
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
    }
}
fun AppCompatTextView.setTextFuture(charSequence: CharSequence){
    this.setTextFuture(PrecomputedTextCompat.getTextFuture(
        charSequence,
        TextViewCompat.getTextMetricsParams(this),
        null
    ))
}
