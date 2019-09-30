package com.example.tinder.Chats

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.tinder.R
import de.hdodenhof.circleimageview.CircleImageView

class inboxAdapter(val context: Context,val list: List<inboxModel>) :BaseAdapter() {


    override fun getItem(p0: Int): Any {
        return list[p0]
    }

    override fun getItemId(p0: Int): Long {

        return 0

    }

    override fun getCount(): Int {

        return list.size
    }

    override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {

        val view:View
        val p=list[p0]

        if (p.isItMe==true){

           view= LayoutInflater.from(context).inflate(R.layout.sent_message_layout,p2,false)

            val t1:TextView=view.findViewById(R.id.mySentMessage)
            val t2:TextView=view.findViewById(R.id.mySentMessageTime)

            t1.text=p.messageSent
            t2.text=p.messageSentTime

        }
        else{


         view= LayoutInflater.from(context).inflate(R.layout.received_message_layout,p2,false)

            val t3:TextView=view.findViewById(R.id.sender_Name)
            val t4:TextView=view.findViewById(R.id.senderTextReceivedTime)
            val t5:TextView=view.findViewById(R.id.senderTextMessage)
            val pic:CircleImageView=view.findViewById(R.id.senderMessageImage)

            t3.text=p.senderName
            t4.text=p.messageReceivedTime
            t5.text=p.messageReceived

            Glide.with(context).load(p.userImage).into(pic)


        }


        return view
    }

}