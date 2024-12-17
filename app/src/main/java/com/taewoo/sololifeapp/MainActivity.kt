package com.taewoo.sololifeapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.auth
import com.taewoo.sololifeapp.R.layout.activity_main
import com.taewoo.sololifeapp.auth.IntroActivity

class MainActivity : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(activity_main)
        auth = Firebase.auth

        findViewById<Button>(R.id.logoutBtn).setOnClickListener {

            /** logout 기능추가 **/
            auth.signOut()

            /** logout 이후 IntroActivity로 이동 **/
            val intent = Intent(this, IntroActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK

        }
    }
}