package com.example.testdemo

import android.graphics.Rect
import android.view.View

/**
 * 浙江集商优选电子商务有限公司
 * @author zenglw
 * @date   20-9-17 下午3:29
 */

//fun View.inScreen(): Boolean? {
//    return kotlin.runCatching {
//
//        val
//    }.onFailure {
//        false
//    }.getOrNull()
//}

val View.inScreen:Boolean
get() {
    val screenWidth = context.resources.displayMetrics.widthPixels

    val screenHeight = context.resources.displayMetrics.heightPixels

    val screenRect = Rect(0, 0, screenWidth, screenHeight)
    val viewLocations = IntArray(2)

    getLocationOnScreen(viewLocations)
    val viewRect = Rect(
        viewLocations[0],
        viewLocations[1],
        viewLocations[0] + width,
        viewLocations[1] + height
    )

    return screenRect.intersect(viewRect)
}