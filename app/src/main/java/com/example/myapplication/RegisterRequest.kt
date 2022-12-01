package com.example.myapplication

import com.android.volley.Response
import com.android.volley.toolbox.StringRequest

class RegisterRequest(
    userID: String,
    userPassword: String,
    userName: String,
    userAge: Int,
    listener: Response.Listener<String>
) : StringRequest(
    Method.POST, URL, listener, null
) {
    private val map: MutableMap<String, String>

    init {
        map = HashMap()
        map["userID"] = userID
        map["userPassword"] = userPassword
        map["userName"] = userName
        map["userAge"] = userAge.toString() + ""
    }


    override fun getParams(): Map<String, String> {
        return map
    }

    companion object {
        // 서버 URL 설정 ( PHP 파일 연동 )
        private const val URL = "http://10.0.2.2/Register.php"
    }
}