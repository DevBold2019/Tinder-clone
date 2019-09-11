package com.example.tinder.Fragments

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

class fragmentAdapter( fm:FragmentManager): FragmentPagerAdapter(fm) {

    val fragList=ArrayList<Fragment>()
    val fragTitle=ArrayList<String>()

    override fun getPageTitle(position: Int): CharSequence? {

       return fragTitle[position]
    }

    override fun getItem(position: Int): Fragment {
        return fragList[position]
    }

    override fun getCount(): Int {
       return fragTitle.size
    }

    fun addFragment(fg:Fragment,title:String){

        fragList.add(fg)
        fragTitle.add(title)

    }
}