package com.mrindeciso.drafter.ui

import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.navArgs
import com.mrindeciso.drafter.databinding.FragmentDrawBinding
import com.mrindeciso.drafter.viewModels.DrawViewModel
import com.mrindeciso.util.viewbinding.ViewBoundFragment
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class DrawFragment : ViewBoundFragment<FragmentDrawBinding>(
    FragmentDrawBinding::inflate
) {

    private val drawViewModel by viewModels<DrawViewModel>()

    private val args: DrawFragmentArgs by navArgs()

    override fun onStart() {
        super.onStart()

        viewLifecycleOwner.lifecycleScope.launch {
            drawViewModel.loadNote(args.noteId)

            binding.stylusView.viewController = drawViewModel.stylusViewController
        }
    }

}