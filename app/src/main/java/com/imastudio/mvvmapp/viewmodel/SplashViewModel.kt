package com.imastudio.mvvmapp.viewmodel

import android.os.Handler
import androidx.databinding.ObservableField
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SplashViewModel : ViewModel() {
    val content  = ObservableField<String>("hi fir")
    private val mutableLiveData = MutableLiveData<SplashState>()
    val liveData :LiveData<SplashState> get() = mutableLiveData

    init {
    Handler().postDelayed({
        content.set("selamat Datang di aplikasi")
        mutableLiveData.postValue(SplashState.pindahHalaman())
    },3000)
    }



    sealed class SplashState{
        class pindahHalaman: SplashState()
    }
}