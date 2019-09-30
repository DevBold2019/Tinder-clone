package com.example.tinder

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import android.widget.Button
import android.widget.TextView
import androidx.viewpager.widget.PagerAdapter
import androidx.viewpager.widget.ViewPager
import com.example.tinder.Registry.RegisterActivity
import com.example.tinder.Registry.SignUpActivity
import com.example.tinder.WalkThroughImplementation.walkAdapter
import com.example.tinder.WalkThroughImplementation.walkModel
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayout.OnTabSelectedListener
import kotlinx.android.synthetic.main.f3_lay.*
class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val list: List<walkModel>
        val adapter: walkAdapter


      //  window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)

        val vpg: ViewPager = findViewById(R.id.viewPager)
        val b1: Button = findViewById(R.id.getStartedButton)
        val b2: Button = findViewById(R.id.nextButton)
        val txt: TextView = findViewById(R.id.skipText)
        val tb: TabLayout = findViewById(R.id.tabLayout)




        list = arrayListOf(
            walkModel("Welcome to Tinder", "Find Love", R.drawable.pic),
            walkModel("Meet singles", "Find Love", R.drawable.pic),
            walkModel("Congratulation", "Get Ready to Find Love", R.drawable.fireworks)
        )


        adapter = walkAdapter(applicationContext, list)
        vpg.adapter = adapter
        tb.setupWithViewPager(vpg)

        b1.visibility = View.INVISIBLE


        b1.setOnClickListener(View.OnClickListener {

           // overridePendingTransition(R.anim.new_page_animation,R.anim.exit_page_animation)
            intent = Intent(applicationContext, RegisterActivity::class.java)
            startActivity(intent)
            finish()


        })
        txt.setOnClickListener(View.OnClickListener {

            vpg.setCurrentItem(list.size-1)
            b1.visibility = View.VISIBLE
            tb.visibility=View.INVISIBLE
            b2.visibility=View.INVISIBLE
            txt.visibility=View.INVISIBLE


        })

        b2.setOnClickListener(View.OnClickListener {
            val position:Int
            position=list.size

            if (vpg.currentItem < list.size){

             vpg.setCurrentItem( vpg.currentItem+1)

            }else if (vpg.currentItem==list.size-1) {
                b1.visibility = View.VISIBLE
                tb.visibility=View.INVISIBLE
                b2.visibility=View.INVISIBLE



            }





        })





    }

}
