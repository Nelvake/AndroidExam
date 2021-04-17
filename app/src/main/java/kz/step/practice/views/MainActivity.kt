package kz.step.practice.views

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.FrameLayout
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import kz.step.practice.R

class MainActivity : AppCompatActivity() {


    var fragmentContainer: FrameLayout? = null

    var currentFragment: Fragment? = null

    var fragmentManager: FragmentManager? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initializeViews()
        if (currentFragment == null) {
            initiateDisplayFragment(EnterFragment())
        }
        val context: Context = MainActivity.applicationContext()
    }

    init {
        instance = this
    }

    companion object {
        private var instance: MainActivity? = null

        fun applicationContext() : Context {
            return instance!!.applicationContext
        }
    }

    fun initializeViews() {
        fragmentContainer = findViewById(R.id.framelayout_activity_main_fragment_container)
    }

    fun applicationContext() : Context {
        return instance!!.applicationContext
    }

    private fun initiateDisplayFragment(fragment: Fragment) {
        fragmentManager = supportFragmentManager

        currentFragment?.run {
            fragmentManager
                ?.beginTransaction()
                ?.hide(currentFragment!!)
        }
        fragmentManager
            ?.beginTransaction()
            ?.add(R.id.framelayout_activity_main_fragment_container, fragment)
            ?.commit()
        currentFragment = fragment
    }
}