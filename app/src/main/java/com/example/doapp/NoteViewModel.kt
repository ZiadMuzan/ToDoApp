package com.example.doapp

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class NoteViewModel(application: Application, private val noteRepository: NoteRepo) : AndroidViewModel(application)  {
fun addNote(note: Note) =viewModelScope.launch {
    noteRepository.insertNote(note)
}
    fun deleteNote(note: Note) =viewModelScope.launch {
        noteRepository.deleteNote(note)
    }

    fun updateNote(note: Note) =viewModelScope.launch {
        noteRepository.updateNote(note)
    }

    fun getAllNote() = noteRepository.getAllNotes()

    fun searchNote(query: String?) = noteRepository.searchNote(query)



}