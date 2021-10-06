package com.mrindeciso.drafter.ui

import androidx.appcompat.content.res.AppCompatResources
import androidx.core.graphics.drawable.toBitmap
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import com.mrindeciso.drafter.R
import com.mrindeciso.drafter.databinding.FragmentDrawBinding
import com.mrindeciso.drafter.ui.drawFragment.BrushButton
import com.mrindeciso.drafter.ui.drawFragment.BrushButtonAdapter
import com.mrindeciso.drafter.viewModels.DrawViewModel
import com.mrindeciso.util.data.Brush
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
        drawViewModel.stylusViewController.selectedBrush = it.brush
        drawViewModel.stylusViewController.isEntireLineEraser = it.isEraser
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
                    it.map { brush -> BrushButton("Brush", brush.renderPreview(), false, brush) }
                )
                brushButtonList.add(
                    BrushButton("Eraser", AppCompatResources.getDrawable(requireContext(), R.drawable.ic_eraser)!!.toBitmap(64, 64), true, Brush())
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