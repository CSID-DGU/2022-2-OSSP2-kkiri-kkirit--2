package com.example.myapplication

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

class RegisterActivity : AppCompatActivity() {
    private var et_id: EditText? = null
    private var et_pass: EditText? = null
    private var et_name: EditText? = null
    private var et_age: EditText? = null
    private var btn_register: Button? = null
    override fun onCreate(savedInstanceState: Bundle?) { // 액티비티 시작시 처음으로 실행되는 생명주기!
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        // 아이디 값 찾아주기
        et_id = findViewById(R.id.edit_id)
        et_pass = findViewById(R.id.edit_pass)
        et_name = findViewById(R.id.edit_name)
        et_age = findViewById(R.id.edit_age)

        // 회원가입 버튼 클릭 시 수행
        btn_register = findViewById(R.id.btn_register)
        btn_register!!.setOnClickListener { // EditText 현재 입력되어있는 값을 get(가져온다)해온다.
            val userID = et_id!!.text.toString()
            val userPass = et_pass!!.text.toString()
            val userName = et_name!!.text.toString()
            val userAge = et_age!!.text.toString().toInt()
            val userTemp = "70".toInt()

            val responseListener: Response.Listener<String> =
                Response.Listener<String> { response ->
                    try {
                        val jsonObject = JSONObject(response)
                        val success = jsonObject.getBoolean("success")
                        if (success) { // 회원등록에 성공한 경우
                            Toast.makeText(
                                applicationContext,
                                "회원 등록에 성공하였습니다.",
                                Toast.LENGTH_SHORT
                            ).show()
                            val intent = Intent(this@RegisterActivity, LoginActivity::class.java)
                            startActivity(intent)
                        } else { // 회원등록에 실패한 경우
                            Toast.makeText(
                                applicationContext,
                                "회원 등록에 실패하였습니다.",
                                Toast.LENGTH_SHORT
                            ).show()
                        }
                    } catch (e: JSONException) {
                        e.printStackTrace()
                    }
                }
                // 서버로 Volley 이용해서 요청을 함.
                val registerRequest = RegisterRequest(userID, userPass, userName, userAge, userTemp, responseListener)
                val queue: RequestQueue = Volley.newRequestQueue(this@RegisterActivity)
                queue.add(registerRequest)

            }
        }
    }


