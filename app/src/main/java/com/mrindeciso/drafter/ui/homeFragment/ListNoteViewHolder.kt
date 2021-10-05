package com.mrindeciso.drafter.ui.homeFragment

import androidx.recyclerview.widget.RecyclerView
import com.mrindeciso.drafter.databinding.ViewholderListnoteBinding
import com.mrindeciso.util.onClick

class ListNoteViewHolder(
    private val binding: ViewholderListnoteBinding
): RecyclerView.ViewHolder(binding.root) {

    fun bind(note: ListNote) = binding.apply {
        noteTitle.text = note.title
        noteSubtitle.text = note.subtitle
        noteLastModified.text = note.lastModified
    }

    fun registerOnClick(onClick: (ListNote) -> Unit, note: ListNote) {
        binding.root.onClick {
            onClick(note)
        }
    }

}