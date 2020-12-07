package com.philabnb.mediadesignhw.page1

import com.philabnb.mediadesignhw.Base.BaseFragment
import com.philabnb.mediadesignhw.HomePage.HomeFragment
import com.philabnb.mediadesignhw.R

class Page1Fragment : BaseFragment(){
    override fun getLayoutRes(): Int = R.layout.fragment_page1

    override fun initData() {
    }

    override fun initObserver() {
    }

    override fun initView() {
    }
    companion object {
        fun newInstance() = Page1Fragment()
    }
}