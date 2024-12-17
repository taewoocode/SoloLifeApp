package com.taewoo.sololifeapp.auth

import android.os.Bundle
import android.widget.Adapter
import android.widget.AdapterView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.databinding.DataBindingUtil
import com.taewoo.sololifeapp.R
import com.taewoo.sololifeapp.databinding.ActivityIntroBinding

class IntroActivity : AppCompatActivity() {

    private lateinit var binding : ActivityIntroBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_intro)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_intro)

    }
}