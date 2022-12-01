package com.example.myapplication
import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle

import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.android.volley.RequestQueue
import com.android.volley.Response
import com.android.volley.toolbox.Volley
import org.json.JSONException
import org.json.JSONObject

class LoginActivity : AppCompatActivity() {
    private var et_id: EditText? = null
    private var et_pass: EditText? = null
    private var btn_login: Button? = null
    private var btn_register: Button? = null
    @SuppressLint("MissingInflatedId")
    protected override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_login)
        et_id = findViewById<EditText>(R.id.edit_id)
        et_pass = findViewById<EditText>(R.id.edit_pass)
        btn_login = findViewById<Button>(R.id.btn_login)
        btn_register = findViewById<Button>(R.id.btn_register)


        // 회원가입 버튼을 클릭 시 수행
        btn_register!!.setOnClickListener {
            val intent = Intent(this@LoginActivity, RegisterActivity::class.java)
            startActivity(intent)
        }
        btn_login!!.setOnClickListener { // EditText에 현재 입력되어있는 값을 get(가져온다)해온다.
            val userID: String = et_id!!.text.toString()
            val userPass: String = et_pass!!.text.toString()
            val responseListener: Response.Listener<String> = object: Response.Listener<String> {
                override fun onResponse(response: String?) {
                    try {
                        // TODO : 인코딩 문제때문에 한글 DB인 경우 로그인 불가
                        println("hongchul$response")
                        val jsonObject = JSONObject(response)
                        val success: Boolean = jsonObject.getBoolean("success")
                        if (success) { // 로그인에 성공한 경우
                            val userID: String = jsonObject.getString("userID")
                            val userPass: String = jsonObject.getString("userPassword")
                            val userName: String = jsonObject.getString("userName")
                            val userAge: String = jsonObject.getString("userAge")
                            Toast.makeText(
                                getApplicationContext(),
                                "로그인에 성공하였습니다.",
                                Toast.LENGTH_SHORT
                            ).show()
                            val intent = Intent(this@LoginActivity, MainActivity::class.java)
                            intent.putExtra("userID", userID)
                            intent.putExtra("userPass", userPass)
                            intent.putExtra("userName", userName)
                            intent.putExtra("userAge", userAge)

                            startActivity(intent)
                        } else { // 로그인에 실패한 경우
                            Toast.makeText(
                                getApplicationContext(),
                                "로그인에 실패하였습니다.",
                                Toast.LENGTH_SHORT
                            ).show()
                            return
                        }
                    } catch (e: JSONException) {
                        e.printStackTrace()
                    }
                }


            }
            val loginRequest = LoginRequest(userID, userPass, responseListener)
            val queue: RequestQueue = Volley.newRequestQueue(this@LoginActivity)
            queue.add(loginRequest)
        }
    }
}