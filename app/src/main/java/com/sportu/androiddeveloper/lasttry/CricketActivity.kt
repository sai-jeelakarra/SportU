package com.sportu.androiddeveloper.lasttry

import android.os.Bundle
import android.support.constraint.ConstraintLayout
import android.support.design.widget.BottomNavigationView
import android.support.design.widget.CoordinatorLayout
import android.support.v4.view.ViewPager
import android.support.v7.app.AppCompatActivity
import com.sportu.androiddeveloper.lasttry.Fragments.NewHomeFragment
import com.sportu.androiddeveloper.lasttry.Fragments.TrendingNewsFragment
import com.sportu.androiddeveloper.lasttry.NewHome.BottomNavigationBehavior
import kotlinx.android.synthetic.main.activity_cricket.*

class CricketActivity : AppCompatActivity() {


    private var viewPager: ViewPager? = null

    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.navigation_home -> {
                try{
                val fragment1 = NewHomeFragment()
                val fragmentTransaction1 = supportFragmentManager.beginTransaction()
                fragmentTransaction1.replace(R.id.fram, fragment1, "Fragment One")  //create first framelayout with id fram in the activity where fragments will be displayed
                fragmentTransaction1.commit()
                return@OnNavigationItemSelectedListener true

                }catch (e:Exception){
                    e.printStackTrace()
                }
            }
            R.id.navigation_dashboard -> {
                try{
                val fragment1 = DashFragment()
                val fragmentTransaction1 = supportFragmentManager.beginTransaction()
                fragmentTransaction1.replace(R.id.fram, fragment1, "Fragment One")  //create first framelayout with id fram in the activity where fragments will be displayed
                fragmentTransaction1.commit()
                return@OnNavigationItemSelectedListener true

                }catch (e:Exception){
                    e.printStackTrace()
                }
            }
            R.id.navigation_notifications -> {
                try{
                val fragment1 = TrendingNewsFragment()
                val fragmentTransaction1 = supportFragmentManager.beginTransaction()
                fragmentTransaction1.replace(R.id.fram, fragment1, "Fragment One")  //create first framelayout with id fram in the activity where fragments will be displayed
                fragmentTransaction1.commit()
                return@OnNavigationItemSelectedListener true

                }catch (e:Exception){
                    e.printStackTrace()
                }
            }
        }
        false
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cricket)


        val layoutParams = navigation.layoutParams as CoordinatorLayout.LayoutParams
        layoutParams.behavior = BottomNavigationBehavior()




        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)

        try {


            val fragment1 = NewHomeFragment()
            val fragmentTransaction1 = supportFragmentManager.beginTransaction()
            fragmentTransaction1.replace(R.id.fram, fragment1, "Fragment One")  //create first framelayout with id fram in the activity where fragments will be displayed
            fragmentTransaction1.commit()

        }catch (e:Exception){
            e.printStackTrace()
        }
    }


}
