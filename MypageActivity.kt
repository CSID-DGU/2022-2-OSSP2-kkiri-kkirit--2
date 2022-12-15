package com.example.myapplication

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


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
            val intent1 = Intent(this@MypageActivity, InfoeditActivity::class.java)
            intent.putExtra("userID", userID)
            intent.putExtra("userPass", userPass)
            intent.putExtra("userName", userName)
            intent.putExtra("userAge", userAge)
            startActivity(intent1)
        }

        val viewmygroup: Button?=findViewById(R.id.goGroupDeliv)

        viewmygroup?.setOnClickListener {
            val intent2=Intent(this@MypageActivity,ViewMygroup::class.java)
            startActivity(intent2)
        }


        val viewevalsc: Button?=findViewById(R.id.goViewSc)

        viewevalsc?.setOnClickListener {
            val intent3=Intent(this@MypageActivity,ViewUserevalActivity::class.java)
            startActivity(intent3)
        }

        val logout: Button?=findViewById(R.id.logout)

        logout?.setOnClickListener{
                val intent4= Intent(this@MypageActivity ,LoginActivity::class.java)

                intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                startActivity(intent4);
            }

    }
}