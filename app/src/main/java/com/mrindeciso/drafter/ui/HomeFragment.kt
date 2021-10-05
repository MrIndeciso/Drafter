package com.mrindeciso.drafter.ui

import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.whenStarted
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.mrindeciso.drafter.databinding.FragmentHomeBinding
import com.mrindeciso.drafter.ui.homeFragment.ListNote
import com.mrindeciso.drafter.ui.homeFragment.ListNoteAdapter
import com.mrindeciso.drafter.viewModels.HomeViewModel
import com.mrindeciso.util.onClick
import com.mrindeciso.util.viewbinding.ViewBoundFragment
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

@AndroidEntryPoint
class HomeFragment : ViewBoundFragment<FragmentHomeBinding>(
    FragmentHomeBinding::inflate
) {

    private val homeViewModel by viewModels<HomeViewModel>()

    private val notesList = mutableListOf<ListNote>()
    private val listNoteAdapter = ListNoteAdapter(notesList) {
        HomeFragmentDirections.actionHomeFragmentToDrawFragment(it.noteId).let {  directions ->
            findNavController().navigate(directions)
        }
    }

    override fun onStart() {
        super.onStart()

        setupFlows()
        setupViews()
    }

    private fun setupFlows() {
        viewLifecycleOwner.lifecycleScope.launch {
            homeViewModel.notes.collect { list ->
                notesList.clear()
                notesList.addAll(list.map { ListNote(it.id, it.title, it.subtitle, it.lastModified.toString()) })

                listNoteAdapter.notifyDataSetChanged()
            }
        }
    }

    private fun setupViews() {
        binding.recViewNotes.setHasFixedSize(true)
        binding.recViewNotes.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
        binding.recViewNotes.adapter = listNoteAdapter

        binding.bttNew.onClick {
            homeViewModel.newNote(
                title = "Provola",
                subtitle = "Provolone",
                category = "Categorone"
            )
        }
    }

}