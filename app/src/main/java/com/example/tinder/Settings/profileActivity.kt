package com.example.tinder.Settings

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.Toolbar
import com.example.tinder.R

class profileActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        val tbl:Toolbar=findViewById(R.id.profileToolbar)

        setSupportActionBar(tbl)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)




    }
}
