package com.example.tinder.Chats

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.tinder.Chats.Inbox.inboxActivity
import com.example.tinder.R
import de.hdodenhof.circleimageview.CircleImageView

class chatAdapter (val context: Context,val list: List<chatModel>): RecyclerView.Adapter<chatAdapter.viewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): viewHolder {

        return viewHolder(LayoutInflater.from(context).inflate(R.layout.chat_lay, parent, false))


    }

    override fun getItemCount(): Int {
        return list.size

    }

    override fun onBindViewHolder(holder: viewHolder, position: Int) {

        val  pos=list[position]

        holder.t1.text=pos.username
        holder.t2.text=pos.message
        holder.pic1.setImageResource(pos.userPic)

        holder.lay.setOnClickListener(View.OnClickListener {

          val intent= Intent(context,inboxActivity::class.java)
            val bundle:Bundle=Bundle()
            bundle.putString("username", holder.t1.text as String)

            context.startActivity(intent)



        })


    }

    class viewHolder(view: View): RecyclerView.ViewHolder(view) {

        val pic1:CircleImageView=view.findViewById(R.id.chatImage)
        val t1:TextView=view.findViewById(R.id.chatName)
        val t2:TextView=view.findViewById(R.id.chatMessage)
        val lay:ConstraintLayout=view.findViewById(R.id.constraint)



    }


}