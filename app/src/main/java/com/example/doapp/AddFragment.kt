package com.example.doapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.*
import android.widget.Toast
import androidx.core.view.MenuHost
import androidx.core.view.MenuProvider
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import com.example.doapp.databinding.FragmentAddBinding

class AddFragment : Fragment(R.layout.fragment_add), MenuProvider {
    private var addNoteBinding: FragmentAddBinding? = null
    private val binding get() = addNoteBinding!!

    private lateinit var notesViewModel: NoteViewModel
    private lateinit var addNoteView: View

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        addNoteBinding = FragmentAddBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val menuHost: MenuHost = requireActivity()
        menuHost.addMenuProvider(this, viewLifecycleOwner, Lifecycle.State.RESUMED)

        // Get the NoteRepository instance and pass it to the ViewModelFactory
        val noteRepository = (activity as MainActivity).noteRepository
        val factory = NoteViewModelFactory(requireActivity().application, noteRepository)
        notesViewModel = ViewModelProvider(this, factory).get(NoteViewModel::class.java)

        addNoteView = view
    }

    private fun saveNote() {
        val noteTitle = binding.addNoteTitle.text.toString().trim()
        val noteDesc = binding.addNoteDesc.text.toString().trim()

        if (noteTitle.isNotEmpty()) {
            val note = Note(0, noteTitle, noteDesc)
            notesViewModel.addNote(note)
            Toast.makeText(context, "Note Saved", Toast.LENGTH_SHORT).show()
            view?.findNavController()?.popBackStack(R.id.homeFragment, false)
        } else {
            Toast.makeText(context, "Please enter the note title", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onCreateMenu(menu: Menu, menuInflater: MenuInflater) {

        menuInflater.inflate(R.menu.menu_add, menu)

    }

    override fun onMenuItemSelected(menuItem: MenuItem): Boolean {
        return when (menuItem.itemId) {
            R.id.saveMenu -> {
                saveNote()
                true
            }
            else -> false
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        addNoteBinding = null
    }
}
