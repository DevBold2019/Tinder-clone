package com.example.tinder.Matches

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.example.tinder.R
import com.example.tinder.WalkThroughImplementation.walkAdapter
import com.example.tinder.WalkThroughImplementation.walkModel

class matchAdapter: BaseAdapter {

     val context:Context
    val listy:List<matchModel>

    constructor(context: Context, listy: List<matchModel>) : super() {
        this.context = context
        this.listy = listy
    }

    override fun getItem(position: Int): matchModel? {
        return listy[position]
    }

    override fun getCount(): Int {
        return listy.size
    }
    override fun getItemId(p0: Int): Long {

        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    @SuppressLint("ViewHolder")
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {

        val view:View=LayoutInflater.from(context).inflate(R.layout.matches_lay,parent,false)

        val contains=listy[position]

        val image:ImageView=view.findViewById(R.id.MateImage)
        val t1:TextView=view.findViewById(R.id.MateName)
        val t2:TextView=view.findViewById(R.id.MateAge)
        val t3:TextView=view.findViewById(R.id.MateLocation)

        t1.text=contains.name
        t2.text=contains.Age
        t3.text=contains.location
        Glide.with(view).load(contains.pic).into(image)




        return view
    }
}