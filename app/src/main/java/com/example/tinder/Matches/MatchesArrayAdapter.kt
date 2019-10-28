package com.example.tinder.Matches

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.example.tinder.R

class MatchesArrayAdapter (context: Context, resourceId: Int, list: MutableList<matchModel>) : ArrayAdapter<matchModel>(context, resourceId,list) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {

        var convertView = convertView
        val model = getItem(position)

        if (convertView !=null){

          convertView =LayoutInflater.from(context).inflate(R.layout.matches_lay,parent,false)

            val name = convertView!!.findViewById(R.id.MateName) as TextView
            val Age = convertView.findViewById(R.id.MateAge) as TextView

            if (model != null) {
                name.setText(model.Name)
                Age.setText(model.Age)
            }


        }



        return convertView!!
    }


}