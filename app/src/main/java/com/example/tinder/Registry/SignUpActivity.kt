package com.example.tinder.Registry

import android.app.Dialog
import android.app.ProgressDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import com.example.tinder.R
import com.example.tinder.Settings.mainSettingsActivity
import com.example.tinder.mainScreen
import com.google.android.gms.tasks.OnCompleteListener
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.activity_sign_up.*

class SignUpActivity : AppCompatActivity() {

    lateinit var fireAuth: FirebaseAuth
    lateinit var dialog: Dialog
    lateinit var email: String
    lateinit var password: String
    lateinit var password2: String
    private lateinit var database: DatabaseReference

    lateinit var radioGroup:RadioGroup
    lateinit var  radioButton :RadioButton
    lateinit var  userId:String
    lateinit var Gender:String

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

        radioGroup=dialog.findViewById(R.id.genderPopRadioGroup)



        //Getting Selected gender from the radioButton
        radioGroup.setOnCheckedChangeListener(object : RadioGroup.OnCheckedChangeListener {
            override fun onCheckedChanged(p0: RadioGroup?, p1: Int) {

                if(R.id.radioMale == p1){

                    Gender = "Male"
                }
                else if (R.id.radioFemale == p1){
                    Gender = "Female"
                }
            }
        })


      /*  pdialog.setTitle("Signing you up")
        pdialog.setMessage("wait a sec")
        pdialog.setCanceledOnTouchOutside(false)*/

        //getting Id of the current user
        userId = fireAuth.getCurrentUser()!!.getUid()

        btn.setOnClickListener(View.OnClickListener {
            email = e1.text.toString()
            password = e2.text.toString()
            dialog.show()

            val text1:TextView=dialog.findViewById(R.id.submitText)

            text1.setOnClickListener(View.OnClickListener {

                Toast.makeText(applicationContext,""+Gender,Toast.LENGTH_LONG).show()
            })


           // pdialog.show()
          /*  fireAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener { task: Task<AuthResult> ->
                if (task.isSuccessful) {

                    dialog.show()

                    val text1:TextView=dialog.findViewById(R.id.submitText)

                    text1.setOnClickListener {

                        database = FirebaseDatabase.getInstance().reference.child("Users").child(radioButton.text.toString()).child(userId)


                        intent= Intent(this,mainSettingsActivity::class.java)
                   startActivity(intent)
                   finish()


                    }


                } else {

                    Toast.makeText(applicationContext,"Cant Register you",Toast.LENGTH_SHORT).show()
                }
            }
*/

        })








}

}


