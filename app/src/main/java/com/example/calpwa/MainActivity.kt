package com.example.calpwa

import android.annotation.SuppressLint
import android.os.Bundle
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    @SuppressLint("SetJavaScriptEnabled")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val webView = WebView(this)
        webView.webViewClient = WebViewClient()  // 내장 브라우저로 열기
        webView.settings.javaScriptEnabled = true  // JavaScript 허용

        // ⬇️ 여기 GCP 서버 주소로 바꿔주세요 (http://34.xxx.xxx.xxx)
        webView.loadUrl("http://34.47.95.140/")

        setContentView(webView)
    }
}
