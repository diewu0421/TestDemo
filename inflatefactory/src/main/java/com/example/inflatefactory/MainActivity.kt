package com.example.inflatefactory

import android.content.Context
import android.os.Bundle
import android.util.AttributeSet
import android.util.Log
import android.view.LayoutInflater
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.tabs.TabLayout
import androidx.viewpager.widget.ViewPager
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.view.View
import androidx.core.view.LayoutInflaterCompat
import com.example.inflatefactory.ui.main.SectionsPagerAdapter

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        LayoutInflaterCompat.setFactory2(LayoutInflater.from(this), object : LayoutInflater.Factory2 {
            override fun onCreateView(parent: View?, name: String?, context: Context, attrs: AttributeSet): View? {
                Log.e("MainActivity", "parent = $parent\nname = $name\ncontext=$context\nattrs=$attrs\n***************************************************************\n")

                var tempName = name
                if (name == "Button") {
                    tempName = "TextView"
                }
                val view = delegate.createView(parent, tempName, context, attrs)

                return view

            }

            override fun onCreateView(name: String?, context: Context?, attrs: AttributeSet?): View? {
                return null
            }

        })
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)
        val sectionsPagerAdapter = SectionsPagerAdapter(this, supportFragmentManager)
        val viewPager: ViewPager = findViewById(R.id.view_pager)
        viewPager.adapter = sectionsPagerAdapter
        val tabs: TabLayout = findViewById(R.id.tabs)
        tabs.setupWithViewPager(viewPager)
        val fab: FloatingActionButton = findViewById(R.id.fab)

        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }
    }
}