package com.example.testlistfromserver.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.testlistfromserver.R
import com.example.testlistfromserver.databinding.ActivityMainBinding
import com.example.testlistfromserver.viewmodel.MaskViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel


class MainActivity : AppCompatActivity() {
    private val viewModel by viewModel<MaskViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding: ActivityMainBinding = DataBindingUtil.setContentView(
            this,
            R.layout.activity_main
        )
        val beginTransaction = supportFragmentManager.beginTransaction()
        val mainFragment = MainFragment()
        viewModel.mask.observe(this) {
            val args = Bundle()
            args.putString("mask", it.phoneMask)
            mainFragment.arguments = args
            beginTransaction.add(R.id.container, mainFragment).commit()
        }
        viewModel.getPhoneMask()
    }
}