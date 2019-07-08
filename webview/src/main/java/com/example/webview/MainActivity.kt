package com.example.webview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.webkit.WebResourceRequest
import android.webkit.WebView
import android.webkit.WebViewClient
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        webview.apply {
            settings.run {
                javaScriptEnabled = true
//                allowFileAccess = false
//                allowUniversalAccessFromFileURLs = false
//                allowFileAccessFromFileURLs = false
            }

            webViewClient = object : WebViewClient() {
                override fun shouldOverrideUrlLoading(view: WebView?, url: String?): Boolean {
                    Log.e("MainAceivity","url = $url")
//                    view?.loadUrl(url)
                    return super.shouldOverrideUrlLoading(view, url)

                }

                override   fun shouldOverrideUrlLoading(view: WebView?, request: WebResourceRequest?): Boolean {
                    Log.e("MainActivity","request = $request url = ${request?.url}")
                    return super.shouldOverrideUrlLoading(view, request)
                }

            }
            loadUrl("file:///android_asset/index.html")

        }
    }
}
