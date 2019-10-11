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
import com.google.android.gms.tasks.OnCompleteListener
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.activity_sign_up.*

class SignUpActivity : AppCompatActivity() {

    lateinit var fireAuth: FirebaseAuth
    lateinit var dialog: Dialog
    lateinit var email: String
    lateinit var password: String
    lateinit var password2: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)


        var fireData: FirebaseDatabase


        //getting instance and the Current user
        fireAuth = FirebaseAuth.getInstance()
        val currentUser = fireAuth.currentUser

        val pdialog: ProgressDialog = ProgressDialog(this)

        /*  val signingUp:ProgressDialog= ProgressDialog(this)
        signingUp.setMessage("Signing up")*/

        dialog = Dialog(this)
        dialog.setContentView(R.layout.select_gender)


        val btn: Button = findViewById(R.id.signUpButton)

        val e1: EditText = findViewById(R.id.emailSignUp)
        val e2: EditText = findViewById(R.id.passwordSignUp)
        val e3: EditText = findViewById(R.id.passwordSignUpConfirm)




        pdialog.setTitle("Signing you up")
        pdialog.setMessage("wait a sec")
        pdialog.setCanceledOnTouchOutside(false)


        btn.setOnClickListener(View.OnClickListener {
            email = e1.text.toString()
            password = e2.text.toString()

            pdialog.show()
            fireAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener { task: Task<AuthResult> ->
                if (task.isSuccessful) {

                    dialog.show()

                    val textt1:TextView=dialog.findViewById(R.id.submitText)
                    textt1.setOnClickListener {

                    intent= Intent(this,mainSettingsActivity::class.java)
                   startActivity(intent)
                   finish()


                    }


                } else {

                    Toast.makeText(applicationContext,"Cant Register you",Toast.LENGTH_SHORT).show()
                }
            }


        })








}

}


