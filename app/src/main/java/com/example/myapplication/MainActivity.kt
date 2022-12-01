package com.example.myapplication

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private var tv_id: TextView? = null
    private var tv_pass: TextView? = null
    private var tv_name: TextView? = null
    private var tv_age: TextView? = null
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val tomypage: Button? = findViewById(R.id.tomypage)
        val todeliveryservice: Button? = findViewById(R.id.todeliveryservice)
        val tofoodservice: Button? = findViewById(R.id.tofoodservice)
        tv_id = findViewById(R.id.main_userid)
        tv_pass = findViewById(R.id.main_userPass)
        tv_name = findViewById(R.id.main_userName)
        tv_age = findViewById(R.id.main_userAge)
        val intent1 = intent
        val userID = intent1.getStringExtra("userID")
        val userPass = intent1.getStringExtra("userPass")
        val userName = intent1.getStringExtra("userName")
        val userAge = intent1.getStringExtra("userAge")
        tv_id!!.text = userID
        tv_pass!!.text = userPass
        tv_name!!.text = userName
        tv_age!!.text = userAge

        tomypage?.setOnClickListener {
            val intent = Intent(this@MainActivity, MypageActivity::class.java)
            intent.putExtra("userID", userID)
            intent.putExtra("userPass", userPass)
            intent.putExtra("userName", userName)
            intent.putExtra("userAge", userAge)
            startActivity(intent)
        }
        todeliveryservice?.setOnClickListener {
            val intent = Intent(this@MainActivity, DelivcategoryActivity::class.java)
            intent.putExtra("userID", userID)
            intent.putExtra("userPass", userPass)
            intent.putExtra("userName", userName)
            intent.putExtra("userAge", userAge)
            startActivity(intent)
        }
        tofoodservice?.setOnClickListener{
            val intent = Intent(this@MainActivity, FoodscategoryActivity::class.java)
            intent.putExtra("userID", userID)
            intent.putExtra("userPass", userPass)
            intent.putExtra("userName", userName)
            intent.putExtra("userAge", userAge)
            startActivity(intent)
        }
    }
}