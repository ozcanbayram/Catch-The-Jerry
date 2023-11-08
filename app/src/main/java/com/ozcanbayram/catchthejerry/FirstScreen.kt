package com.ozcanbayram.catchthejerry

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class FirstScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_first_screen)
    }
    fun start(view : View){
        val intentToMain = Intent(this@FirstScreen,MainActivity::class.java)
        startActivity(intentToMain)
        finish()
    }
    fun exit(view : View){
        System.exit(0)
    }
}