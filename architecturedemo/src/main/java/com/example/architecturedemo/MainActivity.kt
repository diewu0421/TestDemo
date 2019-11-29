package com.example.architecturedemo

import android.app.ActivityManager
import android.content.Context
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.*
import com.example.architecturedemo.room.DataViewModel
import com.example.architecturedemo.room.WeatherResult
import com.example.architecturedemo.ui.main.MainFragment
import com.example.architecturedemo.ui.main.RoomFragment
import com.example.architecturedemo.view.NewItemView
import kotlinx.android.synthetic.main.main_activity.*

class MainActivity : AppCompatActivity(), LifecycleObserver ,LifecycleOwner,RoomFragment.OnFragmentInteractionListener{

    override fun onFragmentInteraction(uri: Uri) {

        Log.e("MainActivity","uri = $uri")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
        Log.e("MainActivity","oncreate")
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, MainFragment.newInstance())
                .commitNow()
        }
        lifecycle.addObserver(this)
        

        room.setOnClickListener {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container,RoomFragment.newInstance("a111","b222)"))
                .commitNow()
        }

        val model = ViewModelProviders.of(this).get(DataViewModel::class.java)
        Log.e("MainActivity","model = $model")
        model.listData.observe(this, Observer {
            Log.e("MainActivity","observer  $it")
        })
        val model1 = ViewModelProviders.of(this).get(DataViewModel::class.java)
        Log.e("MainActivity","model = $model1")

        NewItemView().bindData(tv, "str")



        setResult.setOnClickListener {
            startActivityForResult(Intent(this, Main2Activity::class.java),1001)
        }
//        startService(Intent(this,MyService::class.java))
        Toast.makeText(this,"11x111111fasf",Toast.LENGTH_SHORT).show()
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == 1001) {
            Log.e("MainActivity","intent = $intent")
            startActivity(Intent(this, Main3Activity::class.java))
        }
    }
    override fun onNewIntent(intent: Intent?) {
        super.onNewIntent(intent)
        Log.e("MainActivity","intent $intent")
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    fun onreume() {
        Log.e("MainActivity", "onresume")
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    fun onpause() {

        Log.e("MainActivity","onPause")
    }

    private var mIsRestoredToTop: Boolean = false

    override fun finish() {
        super.finish()
        if (android.os.Build.VERSION.SDK_INT >= 19 && !isTaskRoot && mIsRestoredToTop) {
            // 4.4.2 platform issues for FLAG_ACTIVITY_REORDER_TO_FRONT,
            // reordered activity back press will go to home unexpectly,
            // Workaround: move reordered activity current task to front when it's finished.
            val tasksManager = getSystemService(Context.ACTIVITY_SERVICE) as ActivityManager
            tasksManager.moveTaskToFront(taskId, ActivityManager.MOVE_TASK_NO_USER_ACTION)
        }
    }

    public override fun onDestroy() {
        super.onDestroy()

        Log.e("Main2Activity","odnestorey")
    }

}
