package com.example.tinder.Settings

import android.app.ProgressDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast

import com.example.tinder.mainScreen
import com.google.android.material.textfield.TextInputLayout
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import de.hdodenhof.circleimageview.CircleImageView
import androidx.core.content.ContextCompat.getSystemService
import android.icu.lang.UCharacter.GraphemeClusterBreak.T
import androidx.core.app.ComponentActivity.ExtraData
import androidx.core.content.ContextCompat.getSystemService
import android.icu.lang.UCharacter.GraphemeClusterBreak.T
import com.example.tinder.R
import com.example.tinder.Settings.Model.profile_model
import com.google.android.gms.tasks.OnCompleteListener
import java.util.*
import kotlin.collections.HashMap


class setUpProfile : AppCompatActivity() {

    lateinit var fAuth:FirebaseAuth
    lateinit var currentUserDb:DatabaseReference


    lateinit var  t1:TextInputLayout
    lateinit var  t2:TextInputLayout
    lateinit var  t3:TextInputLayout
    lateinit var gender:String
    lateinit var id:String
    lateinit var progress:ProgressDialog
    lateinit var  currentFirebaseUser: String


    lateinit var namey:String
    lateinit var user:FirebaseUser
    lateinit var about:String
    lateinit var work:String
    lateinit var imageV:CircleImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_set_up_profile)

        progress= ProgressDialog(this)
        progress.setTitle("Saving Profile")
        progress.setMessage("Just a sec")

        fAuth= FirebaseAuth.getInstance()

        //getting curent user
      currentFirebaseUser = fAuth.currentUser!!.uid


        val  bundle:Bundle

        bundle= intent.extras!!
       gender=bundle.getString("gender").toString()
        id=bundle.getString("userid").toString()




        t1=findViewById(R.id.enterName)
        t2=findViewById(R.id.AboutYou)
        t3=findViewById(R.id.WorkPLace)

        imageV=findViewById(R.id.newProfilePic)

        namey=t1.editText!!.text.toString()
        about=t2.editText!!.text.toString()
        work=t3.editText!!.text.toString()


            }

    fun goToMainWindow(view: View) {
        progress.show()



        if (t1.editText!!.text.trim().isNotEmpty() && t2.editText!!.text.trim().isNotEmpty() && t3.editText!!.text.trim().isNotEmpty()){

            currentUserDb=FirebaseDatabase.getInstance().reference.child("Users").child(gender).child(id)

            val data:profile_model=profile_model(namey,work,about)

            currentUserDb.child("Name").setValue(namey)
            currentUserDb.child("Work").setValue(work)
            currentUserDb.child("About").setValue(about).addOnCompleteListener( OnCompleteListener {


                Toast.makeText(this,"saved Sucessfully",Toast.LENGTH_SHORT).show()

                intent = Intent(this, mainScreen::class.java)
                startActivity(intent)
                finish()

            })

            /*val addData=currentUserDb.push().key


            currentUserDb.child(addData!!).setValue(data).addOnCompleteListener(OnCompleteListener {


            })*/


        }else{

            Toast.makeText(this,"Can't save Blank values",Toast.LENGTH_SHORT).show()

        }




            }




}

