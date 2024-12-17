package com.taewoo.sololifeapp.auth

import android.content.Intent
import android.os.Bundle
import android.widget.Adapter
import android.widget.AdapterView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.databinding.DataBindingUtil
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.auth
import com.taewoo.sololifeapp.MainActivity
import com.taewoo.sololifeapp.R
import com.taewoo.sololifeapp.databinding.ActivityIntroBinding

class IntroActivity : AppCompatActivity() {

    private lateinit var auth : FirebaseAuth

    private lateinit var binding : ActivityIntroBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        auth = Firebase.auth

//        setContentView(R.layout.activity_intro)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_intro)

        /** loginBtn 클릭시 이동 **/
        binding.loginBtn.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }

        /** joinBtn 클릭시 이동 **/
        binding.joinBtn.setOnClickListener {
            val intent = Intent(this, JoinActivity::class.java)
            startActivity(intent)
        }

        /** noAccountBtn **/
        binding.noAccountBtn.setOnClickListener {
            auth.signInAnonymously()
                .addOnCompleteListener(this) { task ->
                    if (task.isSuccessful) {

                        /** 로그인 성공시 매인액티비티로 이동 **/
                        val intent = Intent(this, MainActivity::class.java)
                        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                        Toast.makeText(this, "login success", Toast.LENGTH_SHORT).show()
                    } else {
                        Toast.makeText(this, "login false", Toast.LENGTH_SHORT).show()
                    }
                }

        }
    }
}