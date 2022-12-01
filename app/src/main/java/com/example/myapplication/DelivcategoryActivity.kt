package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import android.widget.TextView

class DelivcategoryActivity : AppCompatActivity() {
    private var delivRice: ImageButton? = null
    private var delivPasta: ImageButton? = null
    private var delivChicken: ImageButton? = null
    private var delivPizza: ImageButton? = null
    private var delivBurger: ImageButton? = null
    private var delivDesert: ImageButton? = null

    private var tv_id: TextView? = null
    private var tv_pass: TextView? = null
    private var tv_name: TextView? = null
    private var tv_age: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_delivcategory)

        delivRice = findViewById<ImageButton>(R.id.delivCate_price)
        delivPasta = findViewById<ImageButton>(R.id.delivCate_ppasta)
        delivChicken = findViewById<ImageButton>(R.id.delivCate_pchicken)
        delivPizza = findViewById<ImageButton>(R.id.delivCate_ppizza)
        delivBurger = findViewById<ImageButton>(R.id.delivCate_pburger)
        delivDesert = findViewById<ImageButton>(R.id.delivCate_pdesert)


        val intent1 = intent
        val userID = intent1.getStringExtra("userID")
        val userPass = intent1.getStringExtra("userPass")
        val userName = intent1.getStringExtra("userName")
        val userAge = intent1.getStringExtra("userAge")

        tv_id = findViewById(R.id.dcateUserid)
        tv_pass = findViewById(R.id.dcateUserPass)
        tv_name = findViewById(R.id.dcateUserName)
        tv_age = findViewById(R.id.dcateUserAge)
        tv_id!!.text = userID
        tv_pass!!.text = userPass
        tv_name!!.text = userName
        tv_age!!.text = userAge


        delivRice!!.setOnClickListener {
            val value1: String = "drice"
            val intent = Intent(this, CgdkriceActivity::class.java)
            intent.putExtra("userID", userID)
            intent.putExtra("userPass", userPass)
            intent.putExtra("userName", userName)
            intent.putExtra("userAge", userAge)
            intent.putExtra("food", value1)
            startActivity(intent)
        }
        delivPasta!!.setOnClickListener {
            val value2: String = "dpasta"
            val intent = Intent(this, CgdkriceActivity::class.java)
            intent.putExtra("userID", userID)
            intent.putExtra("userPass", userPass)
            intent.putExtra("userName", userName)
            intent.putExtra("userAge", userAge)
            intent.putExtra("food", value2)
            startActivity(intent)
        }
        delivChicken!!.setOnClickListener {
            val value2: String = "dchicken"
            val intent = Intent(this, CgdkriceActivity::class.java)
            intent.putExtra("userID", userID)
            intent.putExtra("userPass", userPass)
            intent.putExtra("userName", userName)
            intent.putExtra("userAge", userAge)
            intent.putExtra("food", value2)
            startActivity(intent)
        }
        delivPizza!!.setOnClickListener {
            val value2: String = "dpizza"
            val intent = Intent(this, CgdkriceActivity::class.java)
            intent.putExtra("userID", userID)
            intent.putExtra("userPass", userPass)
            intent.putExtra("userName", userName)
            intent.putExtra("userAge", userAge)
            intent.putExtra("food", value2)
            startActivity(intent)
        }
        delivBurger!!.setOnClickListener {
            val value2: String = "dburger"
            val intent = Intent(this, CgdkriceActivity::class.java)
            intent.putExtra("userID", userID)
            intent.putExtra("userPass", userPass)
            intent.putExtra("userName", userName)
            intent.putExtra("userAge", userAge)
            intent.putExtra("food", value2)
            startActivity(intent)
        }
        delivDesert!!.setOnClickListener {
            val value2: String = "ddesert"
            val intent = Intent(this, CgdkriceActivity::class.java)
            intent.putExtra("userID", userID)
            intent.putExtra("userPass", userPass)
            intent.putExtra("userName", userName)
            intent.putExtra("userAge", userAge)
            intent.putExtra("food", value2)
            startActivity(intent)
        }
    }
}