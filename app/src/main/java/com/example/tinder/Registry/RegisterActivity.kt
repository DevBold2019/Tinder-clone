package com.example.tinder.Registry


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
import kotlinx.android.synthetic.main.activity_register.*

class RegisterActivity : AppCompatActivity() {

    lateinit var fAuth:FirebaseAuth


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        fAuth=FirebaseAuth.getInstance()
        val user=fAuth.currentUser



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
           /* pdiag.show()
            intent= Intent(applicationContext,mainScreen::class.java)
            pdiag.dismiss()
            startActivity(intent)
            finish()
*/
           val email = emailLogin.text.toString()
           val password = passwordLogin.text.toString()

            // if (e1.text.toString().isNotEmpty() || e2.text.toString().isNotEmpty()) {

            fAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(this){ task ->

                if (task.isSuccessful){
                    /* dialog.show()
                     val btn:TextView=dialog.findViewById(R.id.submitText)

                     btn.setOnClickListener(View.OnClickListener {
                     })*/
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
}
