package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast
import com.android.volley.RequestQueue
import com.android.volley.Response
import com.android.volley.toolbox.Volley
import org.json.JSONException
import org.json.JSONObject

class UserscActivity : AppCompatActivity() {
    private var bmscore: TextView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_usersc)

        val back_btn: ImageButton? = findViewById(R.id.back_btn)
        bmscore = findViewById(R.id.bmscore)

        val intent1 = intent
        val bmScore = intent1.getStringExtra("bmscore")
        bmscore!!.text = bmScore

        back_btn?.setOnClickListener {
            val intent = Intent(this@UserscActivity, MypageActivity::class.java)
            startActivity(intent)
        }
    }
}
