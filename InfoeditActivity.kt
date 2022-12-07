package com.example.myapplication

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.android.volley.RequestQueue
import com.android.volley.Response
import com.android.volley.toolbox.Volley
import org.json.JSONException
import org.json.JSONObject

class InfoeditActivity : AppCompatActivity() {
    private var tv_id: TextView? = null
    private var tv_name: EditText? = null
    private var tv_age: EditText? = null
    private var tv_pass: EditText? = null
    private var edit_submit: Button? = null
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_infoedit)

        tv_id = findViewById(R.id.info_id)
        tv_name = findViewById<EditText>(R.id.prof_edit_name)
        tv_age = findViewById<EditText>(R.id.prof_edit_age)
        tv_pass = findViewById<EditText>(R.id.prof_edit_pass)

        val intent1 = intent
        val userID = intent1.getStringExtra("userID")
        tv_id!!.text = userID

        edit_submit = findViewById<Button>(R.id.edit_submit)
        edit_submit!!.setOnClickListener {
            val editUserId =  tv_id!!.text.toString()
            val editUsername=  tv_name!!.text.toString()
            val editUserAge = tv_age!!.text.toString().toInt()
            val editUserPass = tv_pass!!.text.toString()

            val responseListener: Response.Listener<String> =
                Response.Listener<String> { response ->
                    /*                  try {
                                          val jsonObject = JSONObject(response)
                                          val success = jsonObject.getBoolean("success")
                                          if (success) { // 업데이트에 성공한 경우
                                              Toast.makeText(
                                                  applicationContext, "회원 정보를 업데이트 하였습니다.",
                                                  Toast.LENGTH_SHORT
                                              ).show()
                                              val intent2 = Intent(this@InfoeditActivity, MypageActivity::class.java)
                                              startActivity(intent2)
                                          } else {
                                              Toast.makeText(
                                                  applicationContext,
                                                  "회원 정보를 업데이트 하지 못하였습니다.",
                                                  Toast.LENGTH_SHORT
                                              ).show()
                                          }
                                      } catch (e: JSONException) {
                                          e.printStackTrace()
                                      }
                  */
                    Toast.makeText(
                        applicationContext, "회원 정보를 업데이트 하였습니다.",
                        Toast.LENGTH_SHORT
                    ).show()
                    val intent2 = Intent(this@InfoeditActivity, LoginActivity::class.java)
                    startActivity(intent2)
                }
            val infoeditRequest =
                InfoeditRequest(editUserId, editUserPass, editUsername, editUserAge, responseListener)
            val queue: RequestQueue = Volley.newRequestQueue(this@InfoeditActivity)
            queue.add(infoeditRequest)
        }
    }
}