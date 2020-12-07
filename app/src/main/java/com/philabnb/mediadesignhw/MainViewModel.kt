package com.philabnb.mediadesignhw

import androidx.lifecycle.ViewModel

class MainViewModel(
    private var toPage1:()->Unit,
    private var toPage2:()->Unit,
    private var toPage3:()->Unit,
    private var toPage4:()->Unit,
    private var toPage5:()->Unit
    ): ViewModel() {
    fun toP1(){
        toPage1()
    }
    fun toP2(){
        toPage2()
    }
    fun toP3(){
        toPage3()
    }
    fun toP4(){
        toPage4()
    }
    fun toP5(){
        toPage5()
    }


    }
