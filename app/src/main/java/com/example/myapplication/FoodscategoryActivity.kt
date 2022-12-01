package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import android.widget.TextView

class FoodscategoryActivity : AppCompatActivity() {
    private var foodRice: ImageButton? = null
    private var foodPasta: ImageButton? = null
    private var foodChicken: ImageButton? = null
    private var foodPizza: ImageButton? = null
    private var foodBurger: ImageButton? = null
    private var foodDesert: ImageButton? = null

    private var tv_id: TextView? = null
    private var tv_pass: TextView? = null
    private var tv_name: TextView? = null
    private var tv_age: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_foodscategory)

        foodRice = findViewById<ImageButton>(R.id.foodCate_price)
        foodPasta = findViewById<ImageButton>(R.id.foodCate_ppasta)
        foodChicken = findViewById<ImageButton>(R.id.foodCate_pchicken)
        foodPizza = findViewById<ImageButton>(R.id.foodCate_ppizza)
        foodBurger = findViewById<ImageButton>(R.id.foodCate_pburger)
        foodDesert = findViewById<ImageButton>(R.id.foodCate_pdesert)

        val intent1 = intent
        val userID = intent1.getStringExtra("userID")
        val userPass = intent1.getStringExtra("userPass")
        val userName = intent1.getStringExtra("userName")
        val userAge = intent1.getStringExtra("userAge")

        tv_id = findViewById(R.id.fcateUserid)
        tv_pass = findViewById(R.id.fcateUserPass)
        tv_name = findViewById(R.id.fcateUserName)
        tv_age = findViewById(R.id.fcateUserAge)
        tv_id!!.text = userID
        tv_pass!!.text = userPass
        tv_name!!.text = userName
        tv_age!!.text = userAge


        foodRice!!.setOnClickListener {
            val value1: String = "frice"
            val intent = Intent(this, CgfkriceActivity::class.java)
            intent.putExtra("userID", userID)
            intent.putExtra("userPass", userPass)
            intent.putExtra("userName", userName)
            intent.putExtra("userAge", userAge)
            intent.putExtra("food", value1)
            startActivity(intent)
        }
        foodPasta!!.setOnClickListener {
            val value2: String = "pasta"
            val intent = Intent(this, CgfkriceActivity::class.java)
            intent.putExtra("userID", userID)
            intent.putExtra("userPass", userPass)
            intent.putExtra("userName", userName)
            intent.putExtra("userAge", userAge)
            intent.putExtra("food", value2)
            startActivity(intent)
        }
        foodChicken!!.setOnClickListener {
            val value2: String = "fchicken"
            val intent = Intent(this, CgfkriceActivity::class.java)
            intent.putExtra("userID", userID)
            intent.putExtra("userPass", userPass)
            intent.putExtra("userName", userName)
            intent.putExtra("userAge", userAge)
            intent.putExtra("food", value2)
            startActivity(intent)
        }
        foodPizza!!.setOnClickListener {
            val value2: String = "fpizza"
            val intent = Intent(this, CgfkriceActivity::class.java)
            intent.putExtra("userID", userID)
            intent.putExtra("userPass", userPass)
            intent.putExtra("userName", userName)
            intent.putExtra("userAge", userAge)
            intent.putExtra("food", value2)
            startActivity(intent)
        }
        foodBurger!!.setOnClickListener {
            val value2: String = "fburger"
            val intent = Intent(this, CgfkriceActivity::class.java)
            intent.putExtra("userID", userID)
            intent.putExtra("userPass", userPass)
            intent.putExtra("userName", userName)
            intent.putExtra("userAge", userAge)
            intent.putExtra("food", value2)
            startActivity(intent)
        }
        foodDesert!!.setOnClickListener {
            val value2: String = "fdesert"
            val intent = Intent(this, CgfkriceActivity::class.java)
            intent.putExtra("userID", userID)
            intent.putExtra("userPass", userPass)
            intent.putExtra("userName", userName)
            intent.putExtra("userAge", userAge)
            intent.putExtra("food", value2)
            startActivity(intent)
        }
    }
}