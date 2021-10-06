package com.mrindeciso.drafter.ui.drawFragment

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.mrindeciso.drafter.databinding.ViewholderBrushBinding
import com.mrindeciso.util.inflateBinding

class BrushButtonAdapter(
    private val brushList: List<BrushButton>,
    private val onClick: (BrushButton) -> Unit,
) : RecyclerView.Adapter<BrushButtonViewHolder>() {

    override fun getItemCount(): Int = brushList.size

    override fun onBindViewHolder(holder: BrushButtonViewHolder, position: Int) {
        holder.bind(brushList[position])
        holder.registerOnClick(onClick, brushList[position])
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BrushButtonViewHolder {
        return BrushButtonViewHolder(
            parent.inflateBinding(ViewholderBrushBinding::inflate)
        )
    }

}