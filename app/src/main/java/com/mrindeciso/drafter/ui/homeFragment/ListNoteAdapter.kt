package com.mrindeciso.drafter.ui.homeFragment

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.mrindeciso.drafter.databinding.ViewholderListnoteBinding
import com.mrindeciso.util.inflateBinding

class ListNoteAdapter(
    private val itemsList: List<ListNote>,
    private val onClick: (ListNote) -> Unit,
) : RecyclerView.Adapter<ListNoteViewHolder>() {

    override fun getItemCount(): Int = itemsList.size

    override fun onBindViewHolder(holder: ListNoteViewHolder, position: Int) {
        holder.bind(itemsList[position])
        holder.registerOnClick(onClick, itemsList[position])
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListNoteViewHolder {
        return ListNoteViewHolder(
            parent.inflateBinding(ViewholderListnoteBinding::inflate)
        )
    }

}