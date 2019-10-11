package com.example.tinder.Fragments

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.tinder.Matches.matchAdapter
import com.example.tinder.Matches.matchModel
import com.example.tinder.R
import com.example.tinder.WalkThroughImplementation.walkModel
import com.lorentzos.flingswipe.SwipeFlingAdapterView


class fragment1 : Fragment() {




    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val list:List<matchModel>
        val adapter:matchAdapter
        val context:Context

        val view: View =inflater.inflate(R.layout.f1_lay,container,false)
        val cards:SwipeFlingAdapterView=view.findViewById(R.id.swipeCard)


      list= arrayListOf(

          matchModel("Meggy","22",R.drawable.curlycurlyhaireyes718978,"Nairobi"),
          matchModel("Keyshia","22",R.drawable.beautifulbodydress944761,"Nairobi"),
          matchModel("Tiana","22",R.drawable.afroattractivebeautiful2701926,"Nairobi"),
          matchModel("Prianca","22",R.drawable.beautifulblackcloseup1689731,"Nairobi"),
          matchModel("Cate","22",R.drawable.afroafrohairbeautiful2519771,"Nairobi"),
          matchModel("Orite","22",R.drawable.orite,"Nairobi"))




        adapter=matchAdapter(container!!.context,list)


       cards.adapter=adapter
        adapter.notifyDataSetChanged()


        cards.setFlingListener(object : SwipeFlingAdapterView.onFlingListener {

            override fun removeFirstObjectInAdapter() {
                // this is the simplest way to delete an object from the Adapter (/AdapterView)
                Log.d("LIST", "removed object!")
                list.removeAt(0)
                adapter.notifyDataSetChanged()
            }

            override fun onLeftCardExit(dataObject: Any) {

                Toast.makeText(container!!.context,"Dislike ",Toast.LENGTH_LONG).show()

            }

            override fun onRightCardExit(dataObject: Any) {

                Toast.makeText(container!!.context,"Like",Toast.LENGTH_LONG).show()

            }

            override fun onAdapterAboutToEmpty(itemsInAdapter: Int) {
                // Ask for more data here
            }

            override fun onScroll(scrollProgressPercent: Float) {

            }



        })


        return view
    }

}