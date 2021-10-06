package com.mrindeciso.drafter.ui

import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import com.mrindeciso.drafter.databinding.FragmentDrawBinding
import com.mrindeciso.drafter.ui.drawFragment.BrushButton
import com.mrindeciso.drafter.ui.drawFragment.BrushButtonAdapter
import com.mrindeciso.drafter.viewModels.DrawViewModel
import com.mrindeciso.util.graphics.renderPreview
import com.mrindeciso.util.viewbinding.ViewBoundFragment
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

@AndroidEntryPoint
class DrawFragment : ViewBoundFragment<FragmentDrawBinding>(
    FragmentDrawBinding::inflate
) {

    private val args: DrawFragmentArgs by navArgs()

    private val drawViewModel by viewModels<DrawViewModel>()

    private val brushButtonList = mutableListOf<BrushButton>()
    private val brushAdapter = BrushButtonAdapter(brushButtonList) {

    }

    override fun onStart() {
        super.onStart()

        setupViews()

        viewLifecycleOwner.lifecycleScope.launch {
            drawViewModel.loadNote(args.noteId)

            binding.stylusView.viewController = drawViewModel.stylusViewController

            drawViewModel.brushes.collect {
                brushButtonList.clear()
                brushButtonList.addAll(
                    it.map { brush -> BrushButton("Brush", brush.renderPreview(), brush) }
                )
                brushAdapter.notifyDataSetChanged()
            }
        }
    }

    private fun setupViews() {
        binding.recViewBrushes.setHasFixedSize(true)
        binding.recViewBrushes.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        binding.recViewBrushes.adapter = brushAdapter
    }

}