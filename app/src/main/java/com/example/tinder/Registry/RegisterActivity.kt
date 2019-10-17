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
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import kotlinx.android.synthetic.main.activity_register.*

class RegisterActivity : AppCompatActivity() {

    lateinit var fAuth:FirebaseAuth
    lateinit var mAuthListenr : FirebaseAuth.AuthStateListener
    lateinit var currentUser:FirebaseUser
    lateinit var dialog:ProgressDialog
    lateinit var e1:EditText
    lateinit var e2:EditText



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        dialog= ProgressDialog(this)
        dialog.setTitle("Loging you in")
        dialog.setMessage("wait For Moment")
        dialog.setCanceledOnTouchOutside(false)

        fAuth=FirebaseAuth.getInstance()
       // val user=fAuth.currentUser





        val txt1:TextView=findViewById(R.id.signupText)
        val txt2:TextView=findViewById(R.id.forgotPassword)
        val btn:Button=findViewById(R.id.loginButton)
         e1=findViewById(R.id.emailLogin)
        e2=findViewById(R.id.passwordLogin)




        txt1.setOnClickListener(View.OnClickListener {

            intent= Intent(applicationContext,SignUpActivity::class.java)
            startActivity(intent)
            finish()


        })


        btn.setOnClickListener(View.OnClickListener {

            dialog.show()

           val email =e1.text.toString()
           val password = e2.text.toString()


            fAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(this){ task ->

                if (task.isSuccessful){
                    dialog.dismiss()
                    checkUser()

                    Toast.makeText(applicationContext,"current User is"+currentUser, Toast.LENGTH_SHORT).show()
                    Toast.makeText(applicationContext,"Sucessfull", Toast.LENGTH_SHORT).show()

                    intent= Intent(this,mainScreen::class.java)
                    startActivity(intent)
                    finish()

                }else{
                    Toast.makeText(applicationContext,"Cant Register you", Toast.LENGTH_SHORT).show()
                }

            }


            //}


        })




    }

    fun checkUser(){

        mAuthListenr=FirebaseAuth.AuthStateListener { object : FirebaseAuth.AuthStateListener  {

            override fun onAuthStateChanged(p0: FirebaseAuth) {

                currentUser= fAuth.currentUser!!

                if (currentUser !=null){

                    intent= Intent(applicationContext,mainScreen::class.java)
                    startActivity(intent)
                    finish()

                    return

                }else{

                    Toast.makeText(applicationContext,"No current User\n please Login or Sign up",Toast.LENGTH_SHORT).show()

                    intent= Intent(applicationContext,RegisterActivity::class.java)
                    startActivity(intent)
                    finish()


                }




            }

        } }



    }


    override fun onStart() {
        super.onStart()
        mAuthListenr?.let { fAuth.addAuthStateListener(it) }
    }

     override fun onStop() {
        super.onStop()
         mAuthListenr?.let { fAuth.removeAuthStateListener(it) }
    }
}
