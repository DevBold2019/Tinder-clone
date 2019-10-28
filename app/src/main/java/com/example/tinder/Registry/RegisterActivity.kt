package com.example.tinder.Registry


import android.app.Dialog
import android.app.ProgressDialog
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
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





        //this functions checks if there is an active user in the app to keep the user logged In
        if (getsaved()){

            intent= Intent(this,mainScreen::class.java)
            startActivity(intent)
            finish()

        }




        //finding Views by id's
        val txt1:TextView=findViewById(R.id.signupText)
        val txt2:TextView=findViewById(R.id.forgotPassword)
        val btn:Button=findViewById(R.id.loginButton)
         e1=findViewById(R.id.emailLogin)
        e2=findViewById(R.id.passwordLogin)




        //takes user to sign up activity
        txt1.setOnClickListener(View.OnClickListener {

            intent= Intent(applicationContext,SignUpActivity::class.java)
            startActivity(intent)
            finish()


        })


        //button handles the saving
        btn.setOnClickListener(View.OnClickListener {

            dialog.show()

           val email =e1.text.toString()
           val password = e2.text.toString()

            if (e1.text.isBlank()|| e2.text.isBlank()){

                Toast.makeText(this,"Can't log in",Toast.LENGTH_SHORT).show()


            }else {

                fAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(this){ task ->

                    currentUser= fAuth.currentUser!!

                    if (task.isSuccessful){
                        dialog.dismiss()

                        Toast.makeText(applicationContext,"Welcome Again", Toast.LENGTH_SHORT).show()

                        saveUser()

                        intent= Intent(this,mainScreen::class.java)
                        startActivity(intent)
                        finish()

                    }else{
                        Toast.makeText(applicationContext,"Cant Register you", Toast.LENGTH_SHORT).show()
                    }

                }

            }


            //signing user


        })

    }

    //saves user login data to keep ém logged in
    /*fun checkUser() {

        mAuthListenr = FirebaseAuth.AuthStateListener { object : FirebaseAuth.AuthStateListener {

                override fun onAuthStateChanged(p0: FirebaseAuth) {

                    currentUser = fAuth.currentUser!!

                    if (currentUser != null) {

                        intent = Intent(applicationContext, mainScreen::class.java)
                        startActivity(intent)
                        finish()

                        return

                    } else {

                        Toast.makeText(applicationContext, "No current User\n please Login or Sign up", Toast.LENGTH_SHORT).show()

                        intent = Intent(applicationContext, RegisterActivity::class.java)
                        startActivity(intent)
                        finish()

                    }

                }


            }
        }


        }*/


    //incase save user fails we store user login details and use it to always keep used logged in
    fun saveUser() {

        val shared: SharedPreferences
        val name: String = "savedata"
        val editor: SharedPreferences.Editor

        shared = getSharedPreferences(name, Context.MODE_PRIVATE)
        editor = shared.edit()
        editor.putBoolean("areYouRegistered", true)
        editor.apply()


    }
    fun getsaved():Boolean{

        val shared: SharedPreferences
        val name: String = "savedata"
        val editor: SharedPreferences.Editor


        shared = getSharedPreferences(name, Context.MODE_PRIVATE)
        val isdata:Boolean=shared.getBoolean("areYouRegistered",false)

        return isdata


    }






}






