package com.mrindeciso.drafter

import android.os.Bundle
import com.mrindeciso.drafter.databinding.ActivityMainBinding
import com.mrindeciso.util.viewbinding.ViewBoundActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ViewBoundActivity<ActivityMainBinding>(
    ActivityMainBinding::inflate
) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

}