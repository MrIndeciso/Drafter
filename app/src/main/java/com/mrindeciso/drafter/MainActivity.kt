package com.mrindeciso.drafter

import androidx.activity.viewModels
import androidx.navigation.findNavController
import androidx.navigation.ui.setupActionBarWithNavController
import com.mrindeciso.drafter.databinding.ActivityMainBinding
import com.mrindeciso.drafter.viewModels.MainViewModel
import com.mrindeciso.util.viewbinding.ViewBoundActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ViewBoundActivity<ActivityMainBinding>(
    ActivityMainBinding::inflate
) {

    private val mainViewModel by viewModels<MainViewModel>()

    override fun onStart() {
        super.onStart()

        setupActionBarWithNavController(findNavController(R.id.nav_host_fragment))

        mainViewModel.setupDB()
    }

}