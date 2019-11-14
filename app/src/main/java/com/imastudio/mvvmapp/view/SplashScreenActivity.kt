package com.imastudio.mvvmapp.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.imastudio.mvvmapp.MainActivity
import com.imastudio.mvvmapp.R
import com.imastudio.mvvmapp.databinding.ActivitySplashScreenBinding
import com.imastudio.mvvmapp.viewmodel.SplashViewModel
import org.jetbrains.anko.startActivity

class SplashScreenActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //instance dataBinding
        var binding = DataBindingUtil.
        setContentView<ActivitySplashScreenBinding>(this,R.layout.activity_splash_screen)
        //instance ViewModel
        binding.viewModel = SplashViewModel()
        val viewModel = ViewModelProviders.of(this)
            .get(SplashViewModel::class.java)
        viewModel.liveData.observe(this, Observer {
            when(it){
                is SplashViewModel.SplashState.pindahHalaman->{
                    startActivity<MainActivity>()
                    finish()
                }
            }
        }

        )

    }
}
