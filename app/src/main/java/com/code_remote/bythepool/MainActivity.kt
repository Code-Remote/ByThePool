package com.code_remote.bythepool

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.e("TAG: MainActivity", "onCreate")
        setContentView(R.layout.activity_main)

        textView3.setOnClickListener {
            val intent = Intent(this, ArchitectureActivity::class.java)
            startActivity(intent)
        }
    }

    override fun onStart() {
        super.onStart()
        Log.e("TAG: MainActivity", "onStart")
    }

    override fun onDestroy() {
        Log.e("TAG: MainActivity", "onDestroy")
        super.onDestroy()
    }

    override fun onResume() {
        super.onResume()
        Log.e("TAG: MainActivity", "onResume")
    }

    override fun onPause() {
        Log.e("TAG: MainActivity", "onPause")
        super.onPause()
    }
}