package com.example.app

import com.android.volley.AuthFailureError
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
class GroupRequest(
    groupAdd:String, HopeAge:String, groupCount: Int,
    HopeSex:String, HopeDate:String, HopeTime:String, Details:String,
    listener: Response.Listener<String?>
):StringRequest(
    Method.POST, URL, listener,null) {
    private val map: Map<String, String>

    init {
        map = HashMap()
        map["groupAdd"] = groupAdd
        map["HopeAge"] = HopeAge
        map["groupCount"] = groupCount.toString()+""
        map["HopeSex"] = HopeSex
        map["HopeDate"] = HopeDate

        map["HopeTime"] =HopeTime
        map["Details"] = Details
    }

    @Throws(AuthFailureError::class)
    override fun getParams(): Map<String, String> {
        return map
    }

    companion object {
        // 서버 URL 설정 ( PHP 파일 연동 )
        private const val URL = "http://10.0.2.2/group.php"
    }

}