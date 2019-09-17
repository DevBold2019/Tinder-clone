package com.example.tinder.Chats.Inbox

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AbsListView
import android.widget.Button
import androidx.appcompat.widget.Toolbar
import com.example.tinder.Chats.inboxAdapter
import com.example.tinder.Chats.inboxModel
import com.example.tinder.R
import com.example.tinder.mainScreen
import kotlinx.android.synthetic.main.activity_inbox.*

class inboxActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_inbox)


        val adapter:inboxAdapter
        val list:List<inboxModel>


        val tlb: Toolbar =findViewById(R.id.inboxToolBar)
        setSupportActionBar(tlb)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)


       val btt:Button=findViewById(R.id.sendMessageButton)

    /*   btt.setOnClickListener(View.OnClickListener {
         val gotText= messageEditText.text.toString()
         messageEditText.text.clear()
        })*/

        list= arrayListOf(
            inboxModel("","",false,"Hello Amos","10:46 am",R.drawable.orite,"Meggy"),

            inboxModel("Hello Meggy","11:00 am",true,"","",R.drawable.orite,"me"))


        adapter= inboxAdapter(applicationContext, list)
        adapter.notifyDataSetChanged()

        inboxRecycler.setSelection(adapter.count-1)
        inboxRecycler.transcriptMode = AbsListView.TRANSCRIPT_MODE_ALWAYS_SCROLL
        inboxRecycler.adapter=adapter



    }

    override fun onBackPressed() {

        intent= Intent(applicationContext,mainScreen::class.java)
        startActivity(intent)
        finish()

        super.onBackPressed()
    }
}
