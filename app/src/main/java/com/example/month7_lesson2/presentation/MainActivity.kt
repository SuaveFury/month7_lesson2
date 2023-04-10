package com.example.month7_lesson2.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.month7_lesson2.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}