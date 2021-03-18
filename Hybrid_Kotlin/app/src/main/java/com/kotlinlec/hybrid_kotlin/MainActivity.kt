package com.kotlinlec.hybrid_kotlin

import android.graphics.Bitmap
import android.net.http.SslError
import android.os.Bundle
import android.view.View
import android.webkit.SslErrorHandler
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {

    var webView: WebView? = null
    var btnReload: Button? = null
    var btnPage1: Button? = null
    var btnPage2: Button? = null
    var btnPage3: Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        webView = findViewById(R.id.webview)
        btnReload = findViewById(R.id.btn_reload)

        btnPage1 = findViewById(R.id.btn_page1)
        btnPage2 = findViewById(R.id.btn_page2)
        btnPage3 = findViewById(R.id.btn_page3)

        btnReload!!.setOnClickListener(onClickListener)
        btnPage1!!.setOnClickListener(onClickListener)
        btnPage2!!.setOnClickListener(onClickListener)
        btnPage3!!.setOnClickListener(onClickListener)

        // Web Setting
        val webSettings = webView?.settings
        webSettings?.javaScriptEnabled = true // JavaScript 사용가능
        webSettings?.builtInZoomControls = true // 확대 축소 가능
        webSettings?.displayZoomControls = false // 돋보기 없애기

        webView?.setWebViewClient(object : WebViewClient() {
            override fun onReceivedSslError(view: WebView?, handler: SslErrorHandler?, error: SslError?) {
                handler?.proceed()
            }
        })
        webView?.loadUrl("https://www.google.com")
    }

    override fun onBackPressed() { // Back Button시 Program종료 방지
        //super.onBackPressed();
        if (webView!!.canGoBack()) {
            webView!!.goBack()
        } else {
            finish()
        }
    }

    private var onClickListener = View.OnClickListener { view ->
        when (view.id) {
            R.id.btn_reload -> btnReloadClick()
            R.id.btn_page1 -> btnPage1Click()
            R.id.btn_page2 -> btnPage2Click()
            R.id.btn_page3 -> btnPage3Click()
        }
    }

    private fun btnReloadClick() {
        webView?.loadUrl("https://www.samsung.com")
    }

    private fun btnPage1Click() {
        webView?.loadUrl("https://www.apple.com")
    }

    private fun btnPage2Click() {
        webView?.loadUrl("https://www.naver.com")
    }

    private fun btnPage3Click() {
        webView?.loadUrl("https://www.daum.com")
    }
} // ------
