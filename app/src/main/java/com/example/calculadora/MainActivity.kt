package com.example.calculadora

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    var contador: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button: Button = findViewById(R.id.button5)
        val text: TextView = findViewById(R.id.result)

        button.setOnClickListener {
            contador++
            text.text = contador.toString()
        }
    }

    override fun onResume() {
        super.onResume()
        Log.d("Debug", "onResume")
        val text: TextView = findViewById(R.id.result)
        text.text = contador.toString()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        outState?.run {
            putInt("contador", contador)
        }
        super.onSaveInstanceState(outState)
    }
    override fun onPause() {
        super.onPause()
        Log.d("Debug", "onPause")
    }
    override fun onDestroy() {
        super.onDestroy()
        Log.d("Debug", "onDestroy")
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        savedInstanceState?.run {
            contador = savedInstanceState.getInt("contador")
            Log.d("Debug", "onRestoreInstanceState: $contador")
        }

    }
    override fun onStart() {
        super.onStart()
        Log.d("Debug", "onStart")
    }
}