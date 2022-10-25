package com.example.memorygame

import android.content.Intent
import android.opengl.Visibility
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.core.view.forEach
import androidx.core.view.isVisible
import com.example.memorygame.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
     private var difficulty: Int? = null
    private lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        //Lògica que vulguem executar abans d'obrir el següent activity


        addEvents(binding)


    }

    private fun addEvents(binding: ActivityMainBinding) {
        val helpText = binding.helpText
        binding.easyButton.setOnClickListener {
            difficulty = binding.easyButton.tag.toString().toInt() - 1
            changeScreen()
        }
        binding.midButton.setOnClickListener {
            difficulty = binding.midButton.tag.toString().toInt() - 1
            changeScreen()
        }
        binding.hardButton.setOnClickListener {
            difficulty = binding.hardButton.tag.toString().toInt() - 1
            changeScreen()
        }
        binding.helpButton.setOnClickListener {
            helpText.visibility = View.VISIBLE
        }
        binding.root.setOnClickListener {
            helpText.visibility = View.INVISIBLE
        }
    }
    private fun changeScreen(){
        val intent = Intent(this, InGameActivity::class.java)
        intent.putExtra("difficulty", difficulty)
        startActivity(intent)
    }

}