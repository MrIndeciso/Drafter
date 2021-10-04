package com.mrindeciso.drafter.ui

import androidx.fragment.app.viewModels
import com.mrindeciso.drafter.databinding.FragmentDrawBinding
import com.mrindeciso.drafter.viewModels.DrawViewModel
import com.mrindeciso.util.viewbinding.ViewBoundFragment

class DrawFragment : ViewBoundFragment<FragmentDrawBinding>(
    FragmentDrawBinding::inflate
) {

    private val drawViewModel by viewModels<DrawViewModel>()

    override fun onStart() {
        super.onStart()

        binding.stylusView.viewController = drawViewModel.controller
    }

}