package com.example.myapplication

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.android.volley.RequestQueue
import com.android.volley.Response
import com.android.volley.toolbox.Volley
import org.json.JSONException
import org.json.JSONObject

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
        val gotoChkDegree: Button? = findViewById(R.id.gotoChkDegree)

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

        gotoChkDegree?.setOnClickListener {
            val userID: String = tv_id!!.text.toString()
            val responseListener: Response.Listener<String> = object: Response.Listener<String> {
                override fun onResponse(response: String?) {
                    val jsonObject = JSONObject(response)
                    val success = jsonObject.getBoolean("success")
                    if (success) {
                        val userTemp = jsonObject.getString("userTemp")
                        val intent1 = Intent(this@MypageActivity, UserscActivity::class.java)
                        intent1.putExtra("bmscore", userTemp)
                        startActivity(intent1)
                    }
//                    if(success && jsonObject.has("bmScore")){
//                        val bmScore: String = jsonObject.getString("bmScore")
//                        bmscore!!.text = bmScore
//                    }
                }
            }
            // 서버로 Volley 이용해서 요청을 함.
            val registerRequest = UserscRequest(userID, responseListener)
            val queue: RequestQueue = Volley.newRequestQueue(this@MypageActivity)
            queue.add(registerRequest)
        }
    }
}