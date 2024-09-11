package com.example.doapp

import android.content.Context
import android.os.Build.VERSION_CODES.N
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    lateinit var noteRepository: NoteRepo

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        // Initialize NoteDatabase and NoteRepo
        val noteDatabase = NoteDatabase.getDatabase(applicationContext)
        noteRepository = NoteRepo(NoteDatabase.getDatabase(applicationContext))
    }
}
