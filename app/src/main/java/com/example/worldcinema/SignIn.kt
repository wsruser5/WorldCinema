 package com.example.worldcinema

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import kotlinx.android.synthetic.main.activity_sign_in.*
import kotlinx.android.synthetic.main.activity_sign_up.*

 class SignIn : AppCompatActivity() {

    var isCanEmail = false
    var isCanEmailVeri = false
    var isCanPass = false
    var isCanName = false
    var isCanFam = false
    var isCanpassAgg = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_in)

        if (etInEmail.getText().toString().equals("")) {
            etInEmail.error = "Заполните поле"
        } else {
            isCanEmail = true }

        if (android.util.Patterns.EMAIL_ADDRESS.matcher(etInEmail.text.toString()).matches()) {
            isCanEmailVeri = true
        } else {
            etInEmail.error = "Неверно введена почта"
            isCanEmailVeri = false }

        if (etInPass.getText().toString().equals("")) {
            isCanPass = false
            etInPass.error = "Заполните поле"
        } else {
            isCanPass = true }

        btnInLogin.setOnClickListener {
            startActivity(Intent(this, MainScreen::class.java))
        }
        btnInReg.setOnClickListener {
            val intent = Intent(this, SignUp::class.java)
            startActivity(intent)
        }
    }
}