package com.mrindeciso.drafter

import android.os.Bundle
import androidx.fragment.app.add
import androidx.fragment.app.commit
import com.mrindeciso.drafter.databinding.ActivityMainBinding
import com.mrindeciso.drafter.ui.DrawFragment
import com.mrindeciso.util.viewbinding.ViewBoundActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ViewBoundActivity<ActivityMainBinding>(
    ActivityMainBinding::inflate
) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        supportFragmentManager.commit {
            add<DrawFragment>(R.id.fragment_container_view)
        }
    }

}