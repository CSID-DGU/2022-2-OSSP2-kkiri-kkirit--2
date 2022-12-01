package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*


class UserevalActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_usereval)

        val spinner = findViewById<Spinner>(R.id.usereval_choice)
        val evUser = findViewById<TextView>(R.id.evUser)

        spinner.adapter = ArrayAdapter.createFromResource(this,R.array.userChoiceList, android.R.layout.simple_spinner_item)
        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onNothingSelected(parent: AdapterView<*>?) {
            }
            override fun onItemSelected(parent:AdapterView<*>?, view: View?, position:Int, id: Long){
                when(position){
                    0->{
                        evUser.setText("유저 1")
                    }
                    1->{
                        evUser.setText("유저 2")
                    }
                    2->{
                        evUser.setText("유저 3")
                    }
                    3->{
                        evUser.setText("유저 4")
                    }
                    else->{
                        evUser.setText("")
                    }
                }
            }
        }
    }
}