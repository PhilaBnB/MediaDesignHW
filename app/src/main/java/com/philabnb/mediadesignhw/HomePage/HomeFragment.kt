package com.philabnb.mediadesignhw.HomePage

import com.philabnb.mediadesignhw.Base.BaseFragment
import com.philabnb.mediadesignhw.MainActivity
import com.philabnb.mediadesignhw.R

class HomeFragment : BaseFragment(){
    override fun getLayoutRes(): Int = R.layout.fragment_home

    override fun initData() {
    }

    override fun initObserver() {
    }

    override fun onFragmentShow() {
        (activity as MainActivity).unlockBottomNavi()
    }

    override fun initView() {
        (activity as MainActivity).unlockBottomNavi()
    }
    companion object {
        fun newInstance() = HomeFragment()
    }

    override fun onBackPress(){
        (activity as MainActivity).confirmExit()
    }
}