package com.philabnb.mediadesignhw.page2

import com.philabnb.mediadesignhw.Base.BaseFragment
import com.philabnb.mediadesignhw.HomePage.HomeFragment
import com.philabnb.mediadesignhw.R

class Page2Fragment : BaseFragment(){
    override fun getLayoutRes(): Int = R.layout.fragment_page2

    override fun initData() {//
    }

    override fun initObserver() {
    }

    override fun initView() {
    }
    companion object {
        fun newInstance() = Page2Fragment()
    }
}