package com.example.tinder.Settings

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.SeekBar
import android.widget.TextView
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.appcompat.widget.Toolbar
import com.example.tinder.R
import com.example.tinder.mainScreen
import java.lang.Byte.MIN_VALUE


class mainSettingsActivity : AppCompatActivity() {

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_settings)

        val tbl: Toolbar =findViewById(R.id.settingsToolbar)

        setSupportActionBar(tbl)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        supportActionBar!!.setTitle("Settings ")
       supportActionBar!!.setDisplayHomeAsUpEnabled(true)

        val s1:SeekBar=findViewById(R.id.distanceSeekBar)
        val s2:SeekBar=findViewById(R.id.ageSeekBar)

        val t1:TextView=findViewById(R.id.displaySetDistance)
        val t2:TextView=findViewById(R.id.setSetAge)


/*

        s1.min=1
        s2.min=18

        t1.text= s1.min.toString()
        t2.text=s2.min.toString()



    if (s1.getProgress() <) {
        seekbar.setProgress(MIN_VALUE);
    }



*/



        if (s1.getProgress() < 5) {
            s1.setProgress(5)
        }


        if (s2.progress<18){
            s2.progress=18
        }

        s1.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener{

            var progressValue:Int=0
            override fun onProgressChanged(p0: SeekBar?, p1: Int, p2: Boolean) {

                progressValue=p1

            }

            override fun onStartTrackingTouch(p0: SeekBar?) {

                progressValue=p0!!.progress

            }

            override fun onStopTrackingTouch(p0: SeekBar?) {

              progressValue=p0!!.progress
                val myset: Int =progressValue
                val km:String="\tKm"
                t1.text=(myset.toString()+km)

            }

        })

        s2.setOnSeekBarChangeListener(object :SeekBar.OnSeekBarChangeListener{

            var mypos:Int=0
            override fun onProgressChanged(p0: SeekBar?, p1: Int, p2: Boolean) {

                mypos=p0!!.progress
                t2.text=mypos.toString()

            }


            @RequiresApi(Build.VERSION_CODES.O)
            override fun onStartTrackingTouch(p0: SeekBar?) {

                val getMinAge:String="18\tyears"
                t2.text=(getMinAge)


            }

            override fun onStopTrackingTouch(p0: SeekBar?) {

                val posi = p0!!.progress

                if (p0.progress < 18) {
                    val Error: String = "Invalid Age"
                    t2.text = Error
                    Toast.makeText(
                        applicationContext,
                        "Not allowed\nBelow 18 Years",
                        Toast.LENGTH_SHORT
                    ).show()

                }
                if (p0.progress==18){
                    val age:String="18 years"
                    t2.text=age

                }
                else if (p0.progress > 18) {

                    val age: String = "18\t-\t\t"
                    t2.text = (age + posi.toString() + "\tYears")


                }



            }


        })







    }

            override fun onBackPressed() {

                intent= Intent(applicationContext,mainScreen::class.java)
                startActivity(intent)
                finish()
        super.onBackPressed()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {

        menuInflater.inflate(R.menu.settings_menu,menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        when(item.itemId){

            R.id.saveSettings ->{

                Toast.makeText(this,"saving your settings",Toast.LENGTH_SHORT).show()

                return true
            }




        }


        return true
    }
}
