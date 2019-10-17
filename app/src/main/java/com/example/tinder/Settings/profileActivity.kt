package com.example.tinder.Settings

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.appcompat.widget.Toolbar
import com.example.tinder.R
import kotlinx.android.synthetic.main.activity_profile.*

class profileActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        val tbl:Toolbar=findViewById(R.id.profileToolbar)

        setSupportActionBar(tbl)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)




    }

    fun editProfile(view: View) {

        intent= Intent(applicationContext,setUpProfile::class.java)
        startActivity(intent)
        finish()


    }
    fun goToSettings(view: View) {

        intent= Intent(applicationContext,mainSettingsActivity::class.java)
        startActivity(intent)
        finish()


    }
}
