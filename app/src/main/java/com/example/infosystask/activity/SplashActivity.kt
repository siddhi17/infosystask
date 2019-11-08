package com.example.infosystask.activity

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import com.example.infosystask.R


class SplashActivity : Activity() {

    // Splash screen timer
    private val SPLASH_TIME_OUT = 3000

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //set view
        setContentView(R.layout.activity_main)

        //move to next activity
        moveToNext()

    }

    private fun moveToNext() {

        Handler().postDelayed(
            {
                // This method will be executed once the timer is over
                startActivity(Intent(this.applicationContext, HomeActivity::class.java))

                // close this activity
                finish()

            }, SPLASH_TIME_OUT.toLong())
    }



}

