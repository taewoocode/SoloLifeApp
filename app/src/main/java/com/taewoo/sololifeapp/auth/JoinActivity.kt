package com.taewoo.sololifeapp.auth

import android.content.Intent
import android.os.Bundle
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
import com.taewoo.sololifeapp.databinding.ActivityJoinBinding

class JoinActivity : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth
    private lateinit var binding: ActivityJoinBinding
    private var isGoToJoin = true


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        auth = Firebase.auth
        binding = DataBindingUtil. setContentView(this, R.layout.activity_join)

        /** joinBtn 클릭 **/
        binding.joinBtn.setOnClickListener {


            val email = binding.emailArea.text.toString()
            val password1 = binding.passwordArea1.text.toString()
            val password2 = binding.passwordArea2.text.toString()

            /** 값이 비어있는지 확인 로직 **/
            isValidate(email, password1, password2)

        }
    }

    fun isValidate(email: String, password1: String, password2: String) {

        /** 이메일이 비었는지 **/
        if (email.isEmpty()) {
            Toast.makeText(this, "이메일을 입력해주세요.", Toast.LENGTH_SHORT).show()

            /** class memeber **/
            isGoToJoin = false;
        }

        /** 비밀번호1이 비었는지 **/
        if (password1.isEmpty()) {
            Toast.makeText(this, "password1를 입력해주세요.", Toast.LENGTH_SHORT).show()
            isGoToJoin = false;
        }

        /** 비밀번호2가 비었는지 **/
        if (password2.isEmpty()) {
            Toast.makeText(this, "password2를 입력해주세요.", Toast.LENGTH_SHORT).show()
            isGoToJoin = false;
        }

        /** 비밀번호가 2개가 같은지 확인 **/
        if (!password1.equals(password2)) {
            Toast.makeText(this, "비밀번호를 똑같이 입력해주세요.", Toast.LENGTH_SHORT).show()
            isGoToJoin = false;
        }

        /** 비밀번호 6  자리 이상으로 입력 **/
        if (password1.length < 6)
            Toast.makeText(this, "비밀번호를 6자리 이상으로 입력해주세요.", Toast.LENGTH_SHORT).show()
            isGoToJoin = false;

        /** 위에 검증을 모두 통과한다면 **/
        if (isGoToJoin) {
            auth.signInWithEmailAndPassword(email, password1)
                .addOnCompleteListener(this) { task ->
                    if (task.isSuccessful) {
                        Toast.makeText(this, "성공", Toast.LENGTH_LONG).show()
                        val intent = Intent(this, MainActivity::class.java)
                        startActivity(intent)
                    } else {
                        Toast.makeText(this, "실패", Toast.LENGTH_LONG).show()

                    }
                }

        }
    }
}