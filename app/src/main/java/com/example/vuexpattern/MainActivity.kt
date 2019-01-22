package com.example.vuexpattern

import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.vuexpattern.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val viewModel by lazy {
        ViewModelProviders.of(this).get(MainViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main).let {
          it.setLifecycleOwner(this)
          it.viewModel = viewModel
        }
    }
}
