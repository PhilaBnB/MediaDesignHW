package com.philabnb.mediadesignhw.Base

import com.philabnb.mediadesignhw.MainViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel {
        MainViewModel(
            get<Navigator>()::toPage1,
            get<Navigator>()::toPage2,
            get<Navigator>()::toPage3,
            get<Navigator>()::toPage4,
            get<Navigator>()::toPage5
        )
    }
}