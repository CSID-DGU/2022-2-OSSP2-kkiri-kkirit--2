package com.example.myapplication

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class MypageActivity : AppCompatActivity() {
    private var tv_id: TextView? = null
    private var tv_pass: TextView? = null
    private var tv_name: TextView? = null
    private var tv_age: TextView? = null
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mypage)
        val infoEdit: Button? = findViewById(R.id.goProfEdit)
        val logout: Button? = findViewById(R.id.logout)
        tv_id = findViewById(R.id.mypage_userid)
        tv_pass = findViewById(R.id.mypage_userPass)
        tv_name = findViewById(R.id.mypage_userName)
        tv_age = findViewById(R.id.mypage_userAge)
        val intent1 = intent
        val userID = intent1.getStringExtra("userID")
        val userPass = intent1.getStringExtra("userPass")
        val userName = intent1.getStringExtra("userName")
        val userAge = intent1.getStringExtra("userAge")
        tv_id!!.text = userID
        tv_pass!!.text = userPass
        tv_name!!.text = userName
        tv_age!!.text = userAge

        infoEdit?.setOnClickListener {
            val intent = Intent(this@MypageActivity, InfoeditActivity::class.java)
            intent.putExtra("userID", userID)
            intent.putExtra("userPass", userPass)
            intent.putExtra("userName", userName)
            intent.putExtra("userAge", userAge)
            startActivity(intent)
        }
        logout?.setOnClickListener {
            val intent2 = Intent(this@MypageActivity, LoginActivity::class.java)
            Toast.makeText(
                applicationContext, "로그아웃이 완료되었습니다.",
                Toast.LENGTH_SHORT
            ).show()
            startActivity(intent2)
        }
    }
}