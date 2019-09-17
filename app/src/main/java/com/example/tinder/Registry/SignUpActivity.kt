package com.example.tinder.Registry

import android.app.Dialog
import android.app.ProgressDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.example.tinder.R
import com.example.tinder.Settings.mainSettingsActivity
import com.example.tinder.mainScreen
import kotlinx.android.synthetic.main.activity_sign_up.*

class SignUpActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        val pdialog:ProgressDialog= ProgressDialog(this)
        val dialog:Dialog= Dialog(this)



        val btn: Button =findViewById(R.id.signUpButton)
        val e1: EditText =findViewById(R.id.emailSignUp)
        val e2: EditText =findViewById(R.id.passwordSignUp)
        val e3: EditText =findViewById(R.id.passwordSignUpConfirm)


        btn.setOnClickListener(View.OnClickListener {


            pdialog.setTitle("Signing you up")
            pdialog.setMessage("wait a sec")
            pdialog.setCanceledOnTouchOutside(false)

            val p3=e3.text.toString()

            if (e2.text.toString().equals(p3)){
/*
                intent= Intent(applicationContext,mainSettingsActivity::class.java)
                startActivity(intent)
                finish()*/

                dialog.setContentView(R.layout.select_gender)
                val tx:TextView=dialog.findViewById(R.id.submitText)


                tx.setOnClickListener(View.OnClickListener {

                    pdialog.dismiss()

                    intent= Intent(applicationContext,mainSettingsActivity::class.java)
                    startActivity(intent)
                    finish()

                })
                dialog.show()




                Toast.makeText(this,"Sucess",Toast.LENGTH_SHORT).show()

            }
            else{

                e2.setError("password dont match")

            }

            pdialog.dismiss()


        })


    }
}
