package com.example.memorygame

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class InGameActivity : AppCompatActivity() {
    lateinit var binding : Any
    private val difficulties = listOf(R.layout.easy_mode,R.layout.mid_mod,R.layout.hard_mode)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val difficulty = intent.extras!!.getInt("difficulty")
            binding = difficulties[difficulty]


    }
}