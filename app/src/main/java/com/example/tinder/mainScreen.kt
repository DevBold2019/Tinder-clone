package com.example.tinder

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.view.WindowManager
import android.widget.ImageView
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.widget.Toolbar
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.FragmentManager
import androidx.viewpager.widget.ViewPager
import com.example.tinder.Fragments.fragment1
import com.example.tinder.Fragments.fragment2
import com.example.tinder.Fragments.fragmentAdapter
import com.example.tinder.Settings.mainSettingsActivity
import com.example.tinder.Settings.profileActivity
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.tabs.TabLayout
import kotlinx.android.synthetic.main.activity_main_screen.*

class mainScreen : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_screen)

      //  window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)

        val adapter: fragmentAdapter

       val tbl: TabLayout = findViewById(R.id.mainScreenTabLayout)
        val vpg: ViewPager = findViewById(R.id.mainScreenViewPager)
        val tlb:   Toolbar=findViewById(R.id.mainScreenToolBar)

       /* val drw:DrawerLayout=findViewById(R.id.myDrawer1)
        val tog: ActionBarDrawerToggle = ActionBarDrawerToggle(this,drw,R.string.open,R.string.close)
        drw.addDrawerListener(tog)
        tog.syncState()*/


      val title:String="Tinder"
        setSupportActionBar(tlb)
        supportActionBar!!.title=title


        adapter = fragmentAdapter(supportFragmentManager)
        adapter.addFragment(fragment1(), "Matches")
        adapter.addFragment(fragment2(), "Chats")

       vpg.adapter = adapter
        tbl.setupWithViewPager(vpg)


    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {

        menuInflater.inflate(R.menu.main_screen_menu,menu)

        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        when(item.itemId){

            R.id.goToSettings ->{

                intent= Intent(applicationContext,mainSettingsActivity::class.java)
                startActivity(intent)
                finish()

                return true
            }

            R.id.goToProfile ->{

                intent= Intent(applicationContext,profileActivity::class.java)
                startActivity(intent)
                finish()

                return true
            }


        }

        return true
    }
}



