package com.example.tinder.Settings

import android.annotation.SuppressLint
import android.app.Activity
import android.app.ProgressDialog
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*

import com.example.tinder.mainScreen
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import de.hdodenhof.circleimageview.CircleImageView

import com.example.tinder.R
import com.example.tinder.Settings.Model.profile_model
import com.google.android.gms.tasks.OnCompleteListener

class setUpProfile : AppCompatActivity() {

    lateinit var fAuth:FirebaseAuth
    lateinit var currentUserDb:DatabaseReference


    lateinit var  t1:EditText
    lateinit var  t2:EditText
    lateinit var  t3:EditText
    lateinit var spinner:Spinner

   var thisyear:Int = 0
   var selectedYear:Int = 0
   var age:Int = 0

    lateinit var result:Uri

    lateinit var gender:String
    lateinit var id:String
    lateinit var progress:ProgressDialog
    lateinit var  currentFirebaseUser: String


    lateinit var namey:String
    lateinit var user:FirebaseUser
    lateinit var about:String
    lateinit var work:String
    lateinit var imageV:CircleImageView

    @SuppressLint("ResourceType")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_set_up_profile)

        progress= ProgressDialog(this)
        progress.setTitle("Saving Profile")
        progress.setMessage("Just a sec")

        fAuth= FirebaseAuth.getInstance()

        //getting current user
      currentFirebaseUser = fAuth.currentUser!!.uid


        val  bundle:Bundle

        bundle= intent.extras!!
       gender=bundle.getString("gender").toString()
        id=bundle.getString("userid").toString()


        t1=findViewById(R.id.enterName)
        t2=findViewById(R.id.AboutYou)
        t3=findViewById(R.id.WorkPLace)
        spinner=findViewById(R.id.getYearOfBirth)


        val adapter = ArrayAdapter.createFromResource(this, R.array.YOB, android.R.layout.simple_spinner_item)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinner.adapter=adapter

        thisyear=2019






        imageV=findViewById(R.id.newProfilePic)
        imageV.setOnClickListener(
            View.OnClickListener {

                Toast.makeText(applicationContext,"Select a picture",Toast.LENGTH_SHORT).show()
                intent= Intent()
                intent.setType("images/*")
                intent.setAction(Intent.ACTION_GET_CONTENT)
                startActivityForResult(intent,1)

            }
        )




            }

    fun goToMainWindow(view: View) {
        progress.show()



        if (t1.text.trim().isNotEmpty() && t2.text.trim().isNotEmpty() && t3.text.trim().isNotEmpty()){

            //getting values of the edit texts

            namey=t1.text.toString()
            about=t2.text.toString()
            work=t3.text.toString()

            selectedYear=Integer.parseInt(spinner.selectedItem.toString())
             age=thisyear-selectedYear


            currentUserDb=FirebaseDatabase.getInstance().reference.child("Users").child(gender).child(id)

            Toast.makeText(applicationContext,"Your age is\t"+age,Toast.LENGTH_SHORT).show()

         /*  val addData=currentUserDb.push().key
           data = profile_model(namey,about,work,age)
            currentUserDb.child(addData!!).setValue(data)
            currentUserDb.child(addData).setValue(data).addOnCompleteListener( OnCompleteListener {
                Toast.makeText(this,"Saved",Toast.LENGTH_SHORT).show()
                intent = Intent(this, mainScreen::class.java)
                startActivity(intent)
                finish()
            })*/

           currentUserDb.child("Name").setValue(namey)
            currentUserDb.child("Work").setValue(work)
            currentUserDb.child("Age").setValue(age).addOnCompleteListener( OnCompleteListener {

                Toast.makeText(this,"Saved",Toast.LENGTH_SHORT).show()

                intent = Intent(this, mainScreen::class.java)
                startActivity(intent)
                finish()

            })

        }else{

            Toast.makeText(this,"Can't save Blank values",Toast.LENGTH_SHORT).show()

        }


            }

    //if the requestCode matches we set the image to the Image view
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode==1 && resultCode== Activity.RESULT_OK){

            val picUri = data!!.data//get data
           result = picUri!!
            imageV.setImageURI(result)

        }
    }



}

