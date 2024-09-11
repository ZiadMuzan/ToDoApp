package com.example.doapp

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class NoteViewModelFactory(private val application: Application, private val noteRepository: NoteRepo) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(NoteViewModel::class.java)){
        return NoteViewModel(application,noteRepository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }

}