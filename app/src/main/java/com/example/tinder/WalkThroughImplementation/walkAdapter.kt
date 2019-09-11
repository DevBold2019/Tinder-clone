package com.example.tinder.WalkThroughImplementation

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.viewpager.widget.PagerAdapter
import com.example.tinder.R

 class walkAdapter: PagerAdapter {

 var  context:Context
 var model:List<walkModel>

        constructor(context: Context,model:List<walkModel>):super (){

            this.model=model
            this.context=context

        }

    override fun isViewFromObject(view: View, `object`: Any): Boolean {

        return view==`object`
    }
    override fun getCount(): Int {
        return model.size
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {

        val view:View=LayoutInflater.from(context).inflate(R.layout.walk_lay,container,false)
        val listOne=model[position]

        val imageView:ImageView=view.findViewById(R.id.walkImageView)
        val t1:TextView=view.findViewById(R.id.walkTitle)
        val t2:TextView=view.findViewById(R.id.walkDescription)



        t1.text=listOne.title
        t2.text=listOne.description
        imageView.setImageResource(listOne.picture)

        container.addView(view)
        return view

    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {

        container.removeView(`object` as View)
    }
}