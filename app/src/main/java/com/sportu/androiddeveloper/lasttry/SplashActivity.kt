package com.sportu.androiddeveloper.lasttry

import android.app.Activity
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.text.TextUtils
import com.bumptech.glide.util.Util
import com.sportu.androiddeveloper.lasttry.InfinityCycle.CarouselActivity
import com.sportu.androiddeveloper.lasttry.R.mipmap.ic_launcher
import android.R.id.edit
import android.content.SharedPreferences
import android.preference.PreferenceManager
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.ImageView
import android.widget.LinearLayout


class SplashActivity : AppCompatActivity() {

    private var mDelayHandler: Handler? = null
    private val SPLASH_DELAY: Long = 2000 //3 seconds

    lateinit var l1: LinearLayout
    lateinit var uptodown: Animation

    internal val mRunnable: Runnable = Runnable {
        if (!isFinishing) {

            val intent = Intent(applicationContext, CarouselActivity::class.java)
            startActivity(intent)
            finish()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)


        try {

            l1 = findViewById(R.id.l1) as LinearLayout
            uptodown = AnimationUtils.loadAnimation(this, R.anim.uptodown)
            l1.animation = uptodown
        }catch (e:Exception){
            e.printStackTrace()
        }


        mDelayHandler = Handler()

        //Navigate with delay
        mDelayHandler!!.postDelayed(mRunnable, SPLASH_DELAY)


        val wmbPreference = PreferenceManager.getDefaultSharedPreferences(this)
        val isFirstRun = wmbPreference.getBoolean("FIRSTRUN", true)
        if (isFirstRun) {

            // Code to run once
            val shortcutIntent = Intent(applicationContext,
                    SplashActivity::class.java)

            shortcutIntent.action = Intent.ACTION_MAIN

            val addIntent = Intent()
            addIntent
                    .putExtra(Intent.EXTRA_SHORTCUT_INTENT, shortcutIntent)
            addIntent.putExtra(Intent.EXTRA_SHORTCUT_NAME, "SportU")
            addIntent.putExtra(Intent.EXTRA_SHORTCUT_ICON_RESOURCE,
                    Intent.ShortcutIconResource.fromContext(applicationContext,
                            R.mipmap.ic_launcher_round))

            addIntent.action = "com.android.launcher.action.INSTALL_SHORTCUT"
            addIntent.putExtra("duplicate", false)  //may it's already there so don't duplicate
            applicationContext.sendBroadcast(addIntent)



            val editor = wmbPreference.edit()
            editor.putBoolean("FIRSTRUN", false)
            editor.commit()
        }




    }


    public override fun onDestroy() {

        if (mDelayHandler != null) {
            mDelayHandler!!.removeCallbacks(mRunnable)
        }

        super.onDestroy()
    }

}
