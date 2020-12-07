package com.philabnb.mediadesignhw.Base

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import com.bumptech.glide.manager.SupportRequestManagerFragment
import com.philabnb.mediadesignhw.EntrancePage
import com.philabnb.mediadesignhw.HomePage.HomeFragment
import com.philabnb.mediadesignhw.MainActivity
import com.philabnb.mediadesignhw.R
import com.philabnb.mediadesignhw.page1.Page1Fragment
import com.philabnb.mediadesignhw.page2.Page2Fragment
import com.philabnb.mediadesignhw.page3.Page3Fragment
import com.philabnb.mediadesignhw.page4.Page4Fragment
import com.philabnb.mediadesignhw.page5.Page5Fragment
import org.koin.ext.getFullName

class Navigator {
    lateinit var activity: FragmentActivity
    var lastAddTime: Long = 0
}
fun Navigator.toHome(){
    addPage(HomeFragment.newInstance())
}
fun Navigator.toPage1(){
    addPage(Page1Fragment.newInstance())
}
fun Navigator.toPage2(){
    addPage(Page2Fragment.newInstance())
}
fun Navigator.toPage3(){
    addPage(Page3Fragment.newInstance())
}
fun Navigator.toPage4(){
    addPage(Page4Fragment.newInstance())
}
fun Navigator.toPage5(){
    addPage(Page5Fragment.newInstance())
}
fun Navigator.toEntrance(){
    addPage(EntrancePage.newInstance())
}

fun Navigator.addPage(fragment: Fragment){
    //unknow
    if (System.currentTimeMillis() - lastAddTime < 500) {
        return
    }
    lastAddTime = System.currentTimeMillis()
    if (activity.supportFragmentManager.fragments.size > 0) {
        var needToHideFragment: Fragment? = null
        for (topFragment in activity.supportFragmentManager.fragments) {
            if (topFragment.isVisible) {
                needToHideFragment = topFragment
            }
        }

        if (needToHideFragment == null) {
            activity.supportFragmentManager.beginTransaction()
                .setCustomAnimations(
                    0,//R.anim.anim_in,
                    0,//R.anim.anim_out,
                    0,//R.anim.pop_in,
                    0,//R.anim.pop_out
                )
                .add(R.id.container, fragment, fragment::class.getFullName())
                .addToBackStack(fragment::class.getFullName())
                .commit()
        } else {
            activity.supportFragmentManager.beginTransaction()
                .setCustomAnimations(
                    0,//R.anim.anim_in,
                    0,//R.anim.anim_out,
                    0,//R.anim.pop_in,
                    0,//R.anim.pop_out
                )
                .add(R.id.container, fragment, fragment::class.getFullName())
                .hide(needToHideFragment)
                .addToBackStack(fragment::class.getFullName())
                .commit()
        }
    } else {
        activity.supportFragmentManager.beginTransaction()
            .setCustomAnimations(
                0,//R.anim.anim_in,
                0,//R.anim.anim_out,
                0,//R.anim.pop_in,
                0,//R.anim.pop_out
            )
            .add(R.id.container, fragment, fragment::class.getFullName())
            .addToBackStack(fragment::class.getFullName())
            .commit()
    }


}
fun Navigator.onBackPress() {
    synchronized(activity.supportFragmentManager) {
        val fragmentManager = activity.supportFragmentManager

        if (fragmentManager.backStackEntryCount == 1) {
            for (fragment in fragmentManager.fragments) {
                if (fragment is SupportRequestManagerFragment) {
                    continue
                }
                if (fragment is EntrancePage
                ) {
                    activity.finish()
                    break
                }
            }
        } else {
            fragmentManager.popBackStack()
        }
    }
}
