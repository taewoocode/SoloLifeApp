package com.taewoo.sololifeapp

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.taewoo.sololifeapp.auth.IntroActivity
import android.os.Handler
import android.util.Log
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.auth

class SplashActivity : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        auth = Firebase.auth

        /** currentUser가 null임을 확인
         * null이라면 바로 null을 반환
         * null이 아니라면 uid에 접근
         * Safe Call Operator
         */
        if (auth.currentUser?.uid == null) {

            /** null이 아니면 IntroActivity **/
            Log.d("Splash Activity", "null")
            Handler().postDelayed({
                startActivity(Intent(this, IntroActivity::class.java))
                finish()
            }, 3000)
        } else {

            /** null이면 MainActivity **/
            Log.d("Splash Activity", "not null")
            /** 3초뒤 splash 화면으로 이동 **/
            Handler().postDelayed({
                startActivity(Intent(this, MainActivity::class.java))
                finish()
            }, 3000)
        }
    }
}