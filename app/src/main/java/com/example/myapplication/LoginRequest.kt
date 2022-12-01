package com.example.myapplication


import com.android.volley.Response
import com.android.volley.toolbox.StringRequest

class LoginRequest(userID: String, userPassword: String, listener: Response.Listener<String>) :
    StringRequest(Method.POST, URL, listener, null) {
    private val map: MutableMap<String, String>
    companion object {
        // 서버 URL 설정 ( PHP 파일 연동 ) - "http://172.20.10.3/login.php"
        private const val URL = "http://10.0.2.2/login.php"
    }
    init{
        map = HashMap()
        map["userID"] = userID
        map["userPassword"] = userPassword
    }

    override fun getParams(): Map<String, String> {
        return map
    }


}