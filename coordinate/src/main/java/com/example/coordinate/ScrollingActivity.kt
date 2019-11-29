package com.example.coordinate
import androidx.fragment.app.Fragment
import com.google.android.material.tabs.TabLayout

import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import androidx.fragment.app.FragmentPagerAdapter
import kotlinx.android.synthetic.main.activity_scrolling.*

class ScrollingActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_scrolling)
//        setSupportActionBar(toolbar)
        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }
        tb.addTab(tb.newTab().setText("title1"))
        tb.addTab(tb.newTab().setText("title2"))
        tb.addTab(tb.newTab().setText("title3"))
        tb.setupWithViewPager(vp)

        vp.adapter = object : FragmentPagerAdapter(supportFragmentManager) {
            override fun getItem(position: Int): Fragment {

                return MyFragment()
            }

            override fun getCount(): Int {
                return 3
            }

            override fun getPageTitle(position: Int): CharSequence? {
                return when (position) {
                    0 -> "title1"
                    1 -> "title2"
                    2 -> "title3"
                    else -> "title"
                }

            }
        }
//        tb.addTab(TabLayout.Tab().setText("1111111111"))
//        tb.addTab(TabLayout.Tab().setText("2222222222"))
//        tb.addTab(tb.newTab().settitle)

    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_scrolling, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.

        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }
}
