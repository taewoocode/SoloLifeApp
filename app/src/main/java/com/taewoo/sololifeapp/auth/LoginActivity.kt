package com.taewoo.sololifeapp.auth

import android.content.Intent
import android.os.Bundle
import android.provider.ContactsContract.Data
import android.util.Log
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
import com.taewoo.sololifeapp.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth
    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        /** databinding layout **/
        binding = DataBindingUtil.setContentView(this, R.layout.activity_login)
        binding.loginBtn.setOnClickListener {
            val email = binding.emailArea.text.toString()
            val password = binding.passwordArea.text.toString()
            auth = Firebase.auth


            auth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this) { task ->
                    if (task.isSuccessful) {
                        Intent(this, MainActivity::class.java)
                        Toast.makeText(this,"success login", Toast.LENGTH_SHORT).show()
                        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                        startActivity(intent)
                    } else {
                        Toast.makeText(this,"success false", Toast.LENGTH_SHORT).show()

                    }
                }

        }

    }
}