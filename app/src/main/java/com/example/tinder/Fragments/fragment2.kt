package com.example.tinder.Fragments

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.HorizontalScrollView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.tinder.Chats.chatAdapter
import com.example.tinder.Chats.chatModel
import com.example.tinder.Chats.newMatchModel
import com.example.tinder.Matches.newMatchAdapter
import com.example.tinder.R


class fragment2 : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val adapter:chatAdapter
        val newAdapter:newMatchAdapter
        val myList:List<newMatchModel>
        val list:List<chatModel>
        val context:Context

        val view:View=inflater.inflate(R.layout.f2_lay,container,false)

        val recycle:RecyclerView=view.findViewById(R.id.chatRecycler)
        recycle.layoutManager= LinearLayoutManager(container!!.context)
        recycle.setHasFixedSize(true)


        list= arrayListOf(
            chatModel("Amos","hello",R.drawable.orite),
            chatModel("Amos","hello",R.drawable.meg),
            chatModel("Amos","hello",R.drawable.orite),
            chatModel("Amos","hello",R.drawable.orite))



        adapter= chatAdapter(container!!.context,list)
        recycle.adapter=adapter
        adapter.notifyDataSetChanged()


        //for new Matches

        val recycle1:RecyclerView=view.findViewById(R.id.matchrecyclerView)

        val horizontalLayoutManager = LinearLayoutManager(container.context, LinearLayoutManager.HORIZONTAL, false)
        recycle1.layoutManager= horizontalLayoutManager
        recycle1.setHasFixedSize(true)


        myList= arrayListOf(newMatchModel(R.drawable.pic,"Edins"),
            newMatchModel(R.drawable.orite,"Edins"),
            newMatchModel(R.drawable.pic,"Edins"),
            newMatchModel(R.drawable.meg,"Edins"))


       newAdapter=newMatchAdapter(container.context,myList)
        recycle1.adapter=newAdapter
        newAdapter.notifyDataSetChanged()


        return view
    }



}