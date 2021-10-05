package com.mrindeciso.drafter

import android.os.Bundle
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.add
import androidx.fragment.app.commit
import androidx.navigation.findNavController
import androidx.navigation.ui.setupActionBarWithNavController
import com.mrindeciso.drafter.databinding.ActivityMainBinding
import com.mrindeciso.drafter.ui.DrawFragment
import com.mrindeciso.util.viewbinding.ViewBoundActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ViewBoundActivity<ActivityMainBinding>(
    ActivityMainBinding::inflate
) {

    override fun onStart() {
        super.onStart()

        setupActionBarWithNavController(findNavController(R.id.nav_host_fragment))
    }

}