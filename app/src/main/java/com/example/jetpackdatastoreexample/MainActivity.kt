package com.example.jetpackdatastoreexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

class MainActivity : AppCompatActivity() {

    private lateinit var backgroundPreference: BackgroundPreference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        backgroundPreference = BackgroundPreference(this)

        redButton.setOnClickListener {
            GlobalScope.launch {
                backgroundPreference.saveBackground(R.color.red)
            }

        }
        greenButton.setOnClickListener {
            GlobalScope.launch {
                backgroundPreference.saveBackground(R.color.green)
            }

        }
        blueButton.setOnClickListener {
            GlobalScope.launch {
                backgroundPreference.saveBackground(R.color.blue)
            }

        }

        GlobalScope.launch {
            backgroundPreference.backgroundColor.collect {

                if(it!=-1)
                {
                    bg.setBackgroundResource(it)
                }

                Log.e("TAG", "onCreate: $it" )
            }
        }



    }
}