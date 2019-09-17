package com.example.tinder.Matches

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.tinder.Chats.chatAdapter
import com.example.tinder.Chats.newMatchModel
import com.example.tinder.R
import de.hdodenhof.circleimageview.CircleImageView

class newMatchAdapter(val context: Context,val listy: List<newMatchModel>):RecyclerView.Adapter<newMatchAdapter.viewHolder>() {



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): newMatchAdapter.viewHolder {

        return viewHolder(LayoutInflater.from(context).inflate(R.layout.new_matches,parent,false))

    }

    override fun getItemCount(): Int {

        return listy.size
    }

    override fun onBindViewHolder(holder: newMatchAdapter.viewHolder, position: Int) {

        val position=listy[position]

        holder.t1.text=position.matchName
        Glide.with(context).load(position.matchPic).into(holder.pic)




    }

    class viewHolder(view:View): RecyclerView.ViewHolder(view) {

        val t1:TextView=view.findViewById(R.id.newMatchName)
        val pic:CircleImageView=view.findViewById(R.id.newMatchImage)



    }







}