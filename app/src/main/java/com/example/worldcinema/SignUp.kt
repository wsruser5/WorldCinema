package com.example.worldcinema

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.util.Patterns
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.mrz.apiwork.SignUpModel
import com.mrz.apiwork.SignUpModelFactory
import com.mrz.apiwork.model.Post
import com.mrz.apiwork.repository.Repository
import kotlinx.android.synthetic.main.activity_sign_up.*

class SignUp : AppCompatActivity() {

    private lateinit var viewModel: SignUpModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        var isCanEmail = false
        var isCanEmailVer = false
        var isCanPass = false
        var isCanName = false
        var isCanFam = false
        var isCanpassAgg = false

        etUpEmail.addTextChangedListener(object: TextWatcher{
            override fun afterTextChanged(s: Editable?) {}
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                if (android.util.Patterns.EMAIL_ADDRESS.matcher(etUpEmail.text.toString()).matches()) {
                    isCanEmail = true
                } else {
                    isCanEmail = false
                    etUpEmail.setError("Неверный e-mail")
                }
            }
        })
        if (etUpName.getText().toString().equals("")) {
            etUpName.error = "Заполните поле"
        }
        if (etUpFam.getText().toString().equals("")) {
            etUpFam.error = "Заполните поле"
        }
        if (etUpEmail.getText().toString().equals("")) {
            etUpEmail.error = "Заполните поле"
        }
        if (etUpPass.getText().toString().equals("")) {
            etUpPass.error = "Заполните поле"
        }
        if (etUpPassAgg.getText().toString().equals("")) {
            etUpPassAgg.error = "Заполните поле"
        }
        if (etUpPass.text != etUpPassAgg.text) {
            etUpPassAgg.error = "Пароли не совпадают"
        }



        val repository = Repository()
        val viewModelFactory = SignUpModelFactory(repository)
        viewModel = ViewModelProvider(this, viewModelFactory).get(SignUpModel::class.java)





        btnUplogin.setOnClickListener {

//            //Отправка данных на серв, сначала грузишь их в этот список, потом отправдяй
//            val myPost = Post(etUpEmail.text.toString(),etUpPass.toString(), etUpName.text.toString(), etUpFam.text.toString())
//            viewModel.register(myPost)
//            viewModel.myResponse.observe(this, Observer { response ->
//                if (response.isSuccessful){
//                    //Проверка через консоль, если выдало код 201, значит все хорошо
//                    Log.d("Main", response.body().toString())
//                    Log.d("Main", response.code().toString())
//                    Log.d("Main", response.message())
//                } else {
//                    //В случае, если все не хорошо, выдаст тост
//                    Toast.makeText(this, response.code(), Toast.LENGTH_SHORT).show()
//                }
//            })
            startActivity(Intent(this, SignIn::class.java))
        }
        btnUpReg.setOnClickListener {
            startActivity(Intent(this, SignIn::class.java))
        }
    }
}