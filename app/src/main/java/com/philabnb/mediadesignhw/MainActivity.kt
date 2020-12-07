package com.philabnb.mediadesignhw

import android.content.DialogInterface
import android.content.pm.ActivityInfo
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.philabnb.mediadesignhw.Base.*
import org.koin.android.ext.android.inject
import org.koin.android.viewmodel.ext.android.viewModel


class MainActivity : AppCompatActivity() {
    private val navigator by inject<Navigator>()
    private val viewModel by viewModel<MainViewModel>()
    lateinit var bottomNavigationView : BottomNavigationView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        this.requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT
        navigator.activity=this
        navigator.toEntrance()
        bottomNavigationView = findViewById<View>(R.id.navigation) as BottomNavigationView
        bottomNavigationView.menu.setGroupCheckable(0, false, false)

//        bottomNavigationView.menu.getItem(1).isEnabled = false

        bottomNavigationView.setOnNavigationItemSelectedListener { item: MenuItem ->
            lockBottomNavi()
            when (item.itemId) {
                R.id.nav1 -> {viewModel.toP1()}
                R.id.nav2 -> {viewModel.toP2()}
                R.id.nav3 -> {viewModel.toP3()}
                R.id.nav4 -> {viewModel.toP4()}
                R.id.nav5 -> {viewModel.toP5()}
            }
            true
        }
    }
    fun removeFragment(fragment: Fragment){
        supportFragmentManager.beginTransaction().remove(fragment).commit()
        //commitNow will error due to sync issue
    }
    fun unlockBottomNavi(){
        bottomNavigationView.visibility = View.VISIBLE
    }
    fun lockBottomNavi(){
        bottomNavigationView.visibility = View.GONE
    }
    override fun onBackPressed() {
        supportFragmentManager.fragments.filter { it.isVisible && it is BaseFragment }.forEach {
            if (it is BaseFragment) {
                it.onBackPress()
            }
        }
    }
    fun confirmExit() {

        val builder = AlertDialog.Builder(this)
        builder.setTitle("確定要離開?")
        builder.setPositiveButton("確定", DialogInterface.OnClickListener { dialog, which ->
            finish()
            dialog.dismiss()
        }).setNegativeButton("取消", DialogInterface.OnClickListener { dialog, which ->
            dialog.dismiss()
        })
        builder.show()
    }
}