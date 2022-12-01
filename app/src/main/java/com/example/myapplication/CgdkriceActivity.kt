package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class CgdkriceActivity : AppCompatActivity() {
    private var tv_id: TextView? = null
    private var tv_pass: TextView? = null
    private var tv_name: TextView? = null
    private var tv_age: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cgdkrice)

        val intent1 = intent
        val userID = intent1.getStringExtra("userID")
        val userPass = intent1.getStringExtra("userPass")
        val userName = intent1.getStringExtra("userName")
        val userAge = intent1.getStringExtra("userAge")

        val delivGroup_create: Button? = findViewById(R.id.delivGroup_create)

        tv_id = findViewById(R.id.cgd_userId)
        tv_pass = findViewById(R.id.cgd_userPass)
        tv_name = findViewById(R.id.cgd_userName)
        tv_age = findViewById(R.id.cgd_userAge)
        tv_id!!.text = userID
        tv_pass!!.text = userPass
        tv_name!!.text = userName
        tv_age!!.text = userAge

        delivGroup_create?.setOnClickListener {
            val intent = Intent(this@CgdkriceActivity, GrouptoghActivity::class.java)
            intent.putExtra("userID", userID)
            intent.putExtra("userPass", userPass)
            intent.putExtra("userName", userName)
            intent.putExtra("userAge", userAge)
            startActivity(intent)
        }

    }
}