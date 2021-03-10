package com.example.worldcinema

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Patterns
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_sign_up.*

class SignUp : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        var isCanEmail = false
        var isCanEmailVer = false
        var isCanPass = false
        var isCanName = false
        var isCanFam = false
        var isCanpassAgg = false

        isCanEmailVer = isEmailValid(etUpEmail.text)

        txt.text = isCanEmailVer.toString()
        if (etUpName.getText().toString().equals("")) {
            isCanName = false
            etUpName.error = "Заполните поле"
        } else {
            isCanName = true }

        if (etUpFam.getText().toString().equals("")) {
            isCanFam = false
            etUpFam.error = "Заполните поле"
        } else {
            isCanFam = true }

        if (etUpEmail.getText().toString().equals("")) {
            etUpEmail.error = "Заполните поле"
        } else {
            isCanEmail = true }

        if (etUpPass.getText().toString().equals("")) {
            isCanPass = false
            etUpPass.error = "Заполните поле"
        } else {
            isCanPass = true }

        if (etUpPassAgg.getText().toString().equals("")) {
            isCanpassAgg = false
            etUpPassAgg.error = "Заполните поле"
        } else {
            isCanpassAgg = true }

        if (etUpPass.text != etUpPassAgg.text) {
            isCanpassAgg = false
            etUpPassAgg.error = "Пароли не совпадают"
        } else {
            isCanpassAgg = true }

        btnUplogin.setOnClickListener {
            startActivity(Intent(this, SignIn::class.java))
        }
        btnUpReg.setOnClickListener {
            startActivity(Intent(this, SignIn::class.java))
        }
    }

    fun isEmailValid(email: CharSequence?): Boolean {
        return Patterns.EMAIL_ADDRESS.matcher(email).matches()
    }
}