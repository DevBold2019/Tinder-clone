package com.example.tinder

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import android.widget.ImageView
import androidx.fragment.app.FragmentManager
import androidx.viewpager.widget.ViewPager
import com.example.tinder.Fragments.fragment1
import com.example.tinder.Fragments.fragment2
import com.example.tinder.Fragments.fragmentAdapter
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.tabs.TabLayout
import kotlinx.android.synthetic.main.activity_main_screen.*

class mainScreen : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_screen)

        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN)

        val adapter:fragmentAdapter

        val tbl:TabLayout=findViewById(R.id.mainScreenTabLayout)
        val vpg:ViewPager=findViewById(R.id.mainScreenViewPager)


        adapter= fragmentAdapter(supportFragmentManager)
        adapter.addFragment(fragment1(),"Matches")
        adapter.addFragment(fragment2(),"Chats")

        vpg.adapter=adapter
        tbl.setupWithViewPager(vpg)


        val faby:FloatingActionButton=findViewById(R.id.fab)
        val i1:ImageView=findViewById(R.id.likes)
        val i2:ImageView=findViewById(R.id.profile)

        i1.visibility=View.INVISIBLE
        i2.visibility=View.INVISIBLE

        faby.setOnClickListener {

            overridePendingTransition(R.anim.new_page_animation,R.anim.exit_page_animation)

            i1.visibility=View.VISIBLE
            i2.visibility=View.VISIBLE
            fab.visibility=View.INVISIBLE


        }


    }






}
