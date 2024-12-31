package com.taewoo.sololifeapp.contentList

import android.os.Bundle
import android.webkit.WebView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.taewoo.sololifeapp.R

class ContentShowActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_content_show)

        val getUrl = intent.getStringExtra("url")
//        Toast.makeText(this,getUrl,Toast.LENGTH_SHORT).show()
        Toast.makeText(this, "입장하셨습니다", Toast.LENGTH_SHORT).show()

        val webView : WebView = findViewById(R.id.webView)
        webView.loadUrl(webView.toString())

    }
}