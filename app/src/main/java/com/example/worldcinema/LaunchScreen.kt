package com.example.worldcinema

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler

class LaunchScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_launch)

        Handler().postDelayed({

            val sp = getSharedPreferences(
                "hasVisited",
                Context.MODE_PRIVATE
            )
            val hasVisited = sp.getBoolean("hasVisited", false)
            if (!hasVisited) {
                val e = sp.edit()
                e.putBoolean("hasVisited", true)
                e.commit()
                var intent = Intent(this, SignUp::class.java)
                startActivity(intent)
                finish()

            } else {

                var intent = Intent(this, SignIn::class.java)
                startActivity(intent)
                finish()

            }

        }, 3000)
    }
}