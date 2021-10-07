package com.mrindeciso.drafter

import androidx.activity.viewModels
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
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

        findNavController(R.id.nav_host_fragment).let { nav ->
            binding.toolbar.setupWithNavController(nav, AppBarConfiguration(nav.graph))
        }

        mainViewModel.setupDB()
    }

}