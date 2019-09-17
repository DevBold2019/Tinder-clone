package com.example.tinder.Registry


import android.app.ProgressDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.example.tinder.R
import com.example.tinder.mainScreen

class RegisterActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)



        val txt1:TextView=findViewById(R.id.signupText)
        val txt2:TextView=findViewById(R.id.forgotPassword)
        val btn:Button=findViewById(R.id.loginButton)
        val e1:EditText=findViewById(R.id.emailLogin)
        val e2:EditText=findViewById(R.id.passwordLogin)

        val pdiag: ProgressDialog=ProgressDialog(this)
        pdiag.setTitle("please wait a sec")
        pdiag.setMessage("Welcome to Tinder")
        pdiag.setCanceledOnTouchOutside(false)




        txt1.setOnClickListener(View.OnClickListener {

            intent= Intent(applicationContext,SignUpActivity::class.java)
            startActivity(intent)
            finish()


        })


        btn.setOnClickListener(View.OnClickListener {
            pdiag.show()
            intent= Intent(applicationContext,mainScreen::class.java)
            pdiag.dismiss()
            startActivity(intent)
            finish()


        })




    }
}
