package com.example.coordinate

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.SimpleAdapter
import androidx.fragment.app.Fragment
import androidx.fragment.app.ListFragment

/**
 * 浙江集商优选电子商务有限公司
 * @author zenglw
 * @date   2019-08-15 11:47
 */
class MyFragment() : ListFragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return super.onCreateView(inflater, container, savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        listAdapter = ArrayAdapter(activity,android.R.layout.simple_list_item_1, android.R.id.text1, arrayListOf<String>().apply {
            for (i in IntRange(1, 50)) {
                add("content = $i")
            }
        })
    }


}