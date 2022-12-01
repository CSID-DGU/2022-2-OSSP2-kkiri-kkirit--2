package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class GroupinfoActivity : AppCompatActivity() {
    private lateinit var region_t: TextView
    private lateinit var old_t: TextView
    private lateinit var person_t: TextView
    private lateinit var sex_t: TextView
    private lateinit var time_t: TextView
    private lateinit var date_t: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_groupinfo)
        region_t = findViewById(R.id.region_info)
        old_t = findViewById(R.id.old_info)
        person_t = findViewById(R.id.person_info)
        sex_t = findViewById(R.id.sex_info)
        time_t = findViewById(R.id.time_info)
        date_t = findViewById(R.id.date_info)

        if (intent.hasExtra("reg")) {
            region_t.append(intent.getStringExtra("reg"))
        }
        if (intent.hasExtra("old")) {
            old_t.append(intent.getStringExtra("old"))
        }
        if (intent.hasExtra("per")) {
            person_t.append(intent.getStringExtra("per"))
        }
        if (intent.hasExtra("sex")) {
            sex_t.append(intent.getStringExtra("sex"))
        }
        if (intent.hasExtra("time")) {
            time_t.append(intent.getStringExtra("time"))
        }
        if (intent.hasExtra("date")) {
            date_t.append(intent.getStringExtra("date"))
        }
    }
}