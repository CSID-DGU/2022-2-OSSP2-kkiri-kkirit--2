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
import com.example.app.GroupRequest
import org.json.JSONException
import org.json.JSONObject

class GrouptoghActivity : AppCompatActivity() {
    private  var groupAdd: EditText?=null
    private  var btn: Button?=null
    private  var HopeAge: EditText?=null
    private  var groupCount: EditText?=null
    private  var HopeSex: EditText?=null
    private  var HopeDate: EditText?=null
    private  var HopeTime: EditText?=null
    private  var Details: EditText?=null
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_grouptogh)
        groupAdd=findViewById(R.id.ADD)
        HopeAge=findViewById(R.id.AGE)
        groupCount=findViewById(R.id.PER)
        HopeSex=findViewById(R.id.SEX)
        HopeDate=findViewById(R.id.DATE)
        HopeTime=findViewById(R.id.TIME)
        Details=findViewById(R.id.Details)
        btn = findViewById(R.id.button2)
        btn!!.setOnClickListener { // EditText 현재 입력되어있는 값을 get(가져온다)해온다.
            val groupAdd = groupAdd!!.text.toString()
            val HopeAge = HopeAge!!.text.toString()
            val groupCount = groupCount!!.text.toString().toInt()
            val HopeSex = HopeSex!!.text.toString()
            val HopeDate = HopeDate!!.text.toString()
            val HopeTime = HopeTime!!.text.toString()
            val Details = Details!!.text.toString()
            val reg =  groupAdd
            val old = HopeAge
            val per = groupCount.toString()
            val sex = HopeSex
            val time = HopeTime
            val date = HopeDate
            val responseListener: Response.Listener<String?> =
                Response.Listener<String?> { response ->
                    try {
                        val jsonObject = JSONObject(response)
                        val success = jsonObject.getBoolean("success")
                        if (success) { // 회원등록에 성공한 경우
                            Toast.makeText(
                                applicationContext,
                                "그룹 생성 성공하였습니다.",
                                Toast.LENGTH_SHORT
                            ).show()
                            val myIntent = Intent(this, GroupinfoActivity::class.java)
                            myIntent.putExtra("reg", reg)
                            myIntent.putExtra("old", old)
                            myIntent.putExtra("per", per)
                            myIntent.putExtra("sex", sex)
                            myIntent.putExtra("time", time)
                            myIntent.putExtra("date", date)
                            startActivity(myIntent)
                        } else { // 회원등록에 실패한 경우
                            Toast.makeText(
                                applicationContext,
                                "그룹 생성 실패하였습니다.",
                                Toast.LENGTH_SHORT
                            ).show()
                        }
                    } catch (e: JSONException) {
                        e.printStackTrace()
                    }
                }
            // 서버로 Volley 이용해서 요청을 함.
            val registerRequest = GroupRequest(groupAdd ,HopeAge,groupCount,HopeSex,HopeDate,HopeTime,Details,responseListener)
            val queue: RequestQueue = Volley.newRequestQueue(this@GrouptoghActivity)
            queue.add(registerRequest)

        }

    }
}