package com.philabnb.mediadesignhw

import com.philabnb.mediadesignhw.Base.BaseFragment
import com.philabnb.mediadesignhw.Base.Navigator
import com.philabnb.mediadesignhw.Base.toHome
import com.philabnb.mediadesignhw.Base.toPage1
import kotlinx.android.synthetic.main.fragment_entrance.*
import org.koin.android.ext.android.inject

class EntrancePage :BaseFragment(){
    private val navigator by inject<Navigator>()
    override fun getLayoutRes(): Int = R.layout.fragment_entrance

    override fun initData() {
    }

    override fun initObserver() {
    }

    override fun onFragmentShow() {
        (activity as MainActivity).lockBottomNavi()
    }

    override fun initView() {
        ll_entrance_page.setOnClickListener {
            navigator.toHome()
        }
    }
    companion object {
        fun newInstance() = EntrancePage()
    }

}