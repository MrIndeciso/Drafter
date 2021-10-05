package com.mrindeciso.drafter.ui.drawFragment

import androidx.recyclerview.widget.RecyclerView
import com.mrindeciso.drafter.databinding.ViewholderBrushBinding
import com.mrindeciso.util.onClick

class BrushButtonViewHolder(
    private val binding: ViewholderBrushBinding
): RecyclerView.ViewHolder(binding.root) {

    fun bind(brush: BrushButton) = binding.apply {
        textView.text = brush.name
        imageView.setImageResource(brush.image)
    }

    fun registerOnClick(onClick: (BrushButton) -> Unit, brush: BrushButton) {
        binding.root.onClick {
            onClick(brush)
        }
    }

}