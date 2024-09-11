package com.example.doapp

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.Navigation.findNavController
import androidx.navigation.findNavController
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.doapp.databinding.FragmentHomeBinding
import com.example.doapp.databinding.NoteLayoutBinding


class NoteAdapter: RecyclerView.Adapter<NoteAdapter.MyHolder>() {
     class MyHolder(val binding:NoteLayoutBinding) : RecyclerView.ViewHolder(binding.root)
    private val differCallback = object : DiffUtil.ItemCallback<Note>() {


        override fun areItemsTheSame(oldItem: Note, newItem: Note): Boolean {
            return oldItem.id == newItem.id &&
                    oldItem.title == newItem.title&&
                    oldItem.description == newItem.description
        }

        override fun areContentsTheSame(oldItem: Note, newItem: Note): Boolean {
            return oldItem==newItem
        }
    }
    val diffre = AsyncListDiffer(this,differCallback)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder {
      return MyHolder(
          NoteLayoutBinding.inflate(
              LayoutInflater.from(parent.context),parent,false))

    }

    override fun getItemCount(): Int {
      return diffre.currentList.size
    }

    override fun onBindViewHolder(holder: MyHolder, position: Int) {
        val currentnote = diffre.currentList[position]
        holder.binding.noteTitle.text = currentnote.title
        holder.binding.noteDesc.text = currentnote.description

        holder.binding.cardView.setOnClickListener {
            val action = HomeFragmentDirections.actionHomeFragmentToEditFragment(currentnote)
            it.findNavController().navigate(action)

        }
    }
}
