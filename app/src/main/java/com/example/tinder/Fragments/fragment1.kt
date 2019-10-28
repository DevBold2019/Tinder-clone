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
import com.example.tinder.Matches.MatchesArrayAdapter
import com.example.tinder.Matches.matchAdapter
import com.example.tinder.Matches.matchModel
import com.example.tinder.R
import com.example.tinder.WalkThroughImplementation.walkModel
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.database.*
import com.lorentzos.flingswipe.SwipeFlingAdapterView


class fragment1 : Fragment() {

    lateinit var FAuth:FirebaseAuth
    lateinit var user:FirebaseUser
    lateinit var CurrentUserMale:DatabaseReference
    lateinit var CurrentUserFeMale:DatabaseReference
    lateinit var CurrentUser:DatabaseReference

    lateinit var userSex:String
    lateinit var OpppositeSex:String

    lateinit var  adapter:MatchesArrayAdapter
    lateinit var  list:MutableList<matchModel>
    lateinit var cards:SwipeFlingAdapterView



    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {





        val view: View =inflater.inflate(R.layout.f1_lay,container,false)
        cards=view.findViewById(R.id.swipeCard)



        getuserSex()



        //setting listener on each swipe
        cards.setFlingListener(object : SwipeFlingAdapterView.onFlingListener {

            override fun removeFirstObjectInAdapter() {
                // this is the simplest way to delete an object from the Adapter (/AdapterView)

                list.removeAt(0)
                adapter.notifyDataSetChanged()
            }

            override fun onLeftCardExit(dataObject: Any) {

                Toast.makeText(getContext(),"Dislike ",Toast.LENGTH_LONG).show()

            }

            override fun onRightCardExit(dataObject: Any) {

                Toast.makeText(getContext(),"Like",Toast.LENGTH_LONG).show()

            }

            override fun onAdapterAboutToEmpty(itemsInAdapter: Int) {
                // Ask for more data here
            }

            override fun onScroll(scrollProgressPercent: Float) {

            }



        })







        return view
    }

    fun getuserSex(){

        FAuth= FirebaseAuth.getInstance()

        user=FAuth.currentUser!!


        //If the user is Male we set the user sex to male but first we use the user id to know
        CurrentUserMale=FirebaseDatabase.getInstance().reference.child("Users").child("Male")
       CurrentUserMale.addChildEventListener(object : ChildEventListener {

           override fun onChildAdded(p0: DataSnapshot, p1: String?) {
               if (p0.key!!.equals(user.uid)){

                   userSex="Male"
                   OpppositeSex="Female"
                   getTheOppositeSex()
                   Toast.makeText(context,""+userSex,Toast.LENGTH_SHORT).show()
               }

           }
           override fun onCancelled(p0: DatabaseError) {
           }
           override fun onChildMoved(p0: DataSnapshot, p1: String?) {
           }
           override fun onChildChanged(p0: DataSnapshot, p1: String?) {
           }
           override fun onChildRemoved(p0: DataSnapshot) {
           }
       })


        //If the user is female
        CurrentUserFeMale=FirebaseDatabase.getInstance().reference.child("Users").child("Female")
        CurrentUserFeMale.addChildEventListener(object : ChildEventListener {

            override fun onChildAdded(p0: DataSnapshot, p1: String?) {
                if (p0.key.equals(user.uid)){
                    userSex="Female"
                    OpppositeSex="Male"
                    getTheOppositeSex()
                    Toast.makeText(context,""+userSex,Toast.LENGTH_SHORT).show()

                }
            }
            override fun onCancelled(p0: DatabaseError) {
            }
            override fun onChildMoved(p0: DataSnapshot, p1: String?) {
            }
            override fun onChildChanged(p0: DataSnapshot, p1: String?) {
            }
            override fun onChildRemoved(p0: DataSnapshot) {
            }
        })


    }

    fun getTheOppositeSex(){

        CurrentUser=FirebaseDatabase.getInstance().reference.child("Users").child(userSex)
        CurrentUser.addChildEventListener(object : ChildEventListener {

            override fun onChildAdded(p0: DataSnapshot, p1: String?) {

                if (p0.exists()){

                    //val key=p0.key
                    Toast.makeText(context,"Loading Data",Toast.LENGTH_SHORT).show()

                    list= mutableListOf(matchModel(p0.child("Name").value.toString(),p0.child("Age").value.toString()))

                    adapter=MatchesArrayAdapter(context!!,R.layout.matches_lay,list)
                    adapter.notifyDataSetChanged()
                    cards.adapter=adapter

                }else{
                    Toast.makeText(context,"No Data",Toast.LENGTH_SHORT).show()
                }
            }
            override fun onCancelled(p0: DatabaseError) {
            }
            override fun onChildMoved(p0: DataSnapshot, p1: String?) {
            }
            override fun onChildChanged(p0: DataSnapshot, p1: String?) {
            }
            override fun onChildRemoved(p0: DataSnapshot) {

            }
        })





    }

}