package com.example.recyclerviewdemo

import android.content.Context
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Environment
import android.os.Handler
import android.text.PrecomputedText
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.appcompat.widget.AppCompatTextView
import androidx.collection.arraySetOf
import androidx.core.text.PrecomputedTextCompat
import androidx.core.widget.TextViewCompat
import androidx.fragment.app.*
import androidx.lifecycle.*
import androidx.work.*
import androidx.work.impl.utils.taskexecutor.WorkManagerTaskExecutor
import io.reactivex.rxjava3.core.Flowable
import io.reactivex.rxjava3.core.Scheduler
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_layout.*
import kotlinx.coroutines.*
import java.io.File
import java.lang.Runnable
import java.time.Duration
import java.util.concurrent.TimeUnit
import java.util.jar.Manifest


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        File(("${getExternalFilesDir(Environment.DIRECTORY_DOWNLOADS)}${File.separatorChar}testCreate.txt"))
            .let { it ->
                if (!it.exists()) {
                    it.createNewFile().also {
                        Log.e("MainActivity","onCreate createNewFile $it")
                    }
                }

                it.writeText("11111")
            }

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

    fun getUsersLiveData(): LiveData<String> {
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

    @RequiresApi(Build.VERSION_CODES.M)
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
            Log.e("MyFragment", "onViewCreated observeForever $it")
        }
//        val request = OneTimeWorkRequestBuilder<MyWorker>()
//            .setInitialDelay(2, TimeUnit.SECONDS)
//            .setInputData(Data.Builder().putString("putData", "我是好人").build())
//            .setBackoffCriteria(BackoffPolicy.LINEAR, 2, TimeUnit.SECONDS)
//            .build()

        // PeriodBuild
        val request =
            PeriodicWorkRequestBuilder<MyWorker>(5, TimeUnit.SECONDS)
                .setConstraints(
                    Constraints(
                        Constraints.Builder()
                            .setRequiredNetworkType(NetworkType.CONNECTED)
                            .setRequiresBatteryNotLow(true)
                            .setRequiresStorageNotLow(true)
                            .setRequiresDeviceIdle(false)
                            .build()
                    )
                )
                .build()

        WorkManager.getInstance(requireContext()).getWorkInfoByIdLiveData(request.id)
            .observe(viewLifecycleOwner, Observer<WorkInfo> { info ->
                when (info.state) {
                    WorkInfo.State.BLOCKED -> {

                        println("11111 blocked")
                    }
                    WorkInfo.State.SUCCEEDED -> {

                        val result = info.outputData.getString("result")
                        println("11111 success $result")

                    }
                    WorkInfo.State.FAILED -> {

                        println("11111 failed")
                    }
                    WorkInfo.State.CANCELLED -> {

                        println("11111 cancelled")
                    }
                    WorkInfo.State.RUNNING -> {
                        println("11111 running progress ${info.progress.getInt("progress", -1)}")

                    }
                    WorkInfo.State.ENQUEUED -> {
                        println("11111 enqueued")
                    }
                }
            })
//        val workInfo = WorkManager.getInstance(requireContext()).getWorkInfoById(request.id).get()
//        println("11111 ${workInfo}")

        WorkManager.getInstance(requireContext()).enqueue(request)

        // 取消任务
//        Handler().postDelayed({
//            WorkManager.getInstance(requireContext()).cancelWorkById(request.id)
//        }, 3000)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
    }
}

fun AppCompatTextView.setTextFuture(charSequence: CharSequence) {
    this.setTextFuture(
        PrecomputedTextCompat.getTextFuture(
            charSequence,
            TextViewCompat.getTextMetricsParams(this),
            null
        )
    )
}

class MyWorker(context: Context, workerParameters: WorkerParameters) :
    Worker(context, workerParameters) {
    private var mCount = 0

    override fun doWork(): Result {
//        val result = inputData.getString("putData")?.also {
//            println("it = $it ${Thread.currentThread().name}")
//        }
        // 进度测试
//        for (i in 0..100) {
//            setProgressAsync(Data.Builder().putInt("progress", i).build())
//            Thread.sleep(1000L)
//        }
//        println("11111 count = $mCount $this")
//        if (mCount < 5) {
//            mCount++
//            return Result.retry()
//        }
        return Result.success(Data.Builder().putString("result", "成功了").build())
    }

    override fun onStopped() {
        super.onStopped()
        println("11111 onStopped")
    }

}
