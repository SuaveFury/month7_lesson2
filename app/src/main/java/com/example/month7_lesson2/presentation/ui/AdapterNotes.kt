package com.example.month7_lesson2.presentation.ui

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.month7_lesson2.databinding.ItemNoteBinding
import com.example.month7_lesson2.domain.model.Note

class AdapterNotes(private val click:(Note)->Unit,
                   private val onLongClick:(Note)->Unit)
    : ListAdapter<Note, AdapterNotes.ViewHolderNotes>(
    DFUtilCallBack()
){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderNotes {
        return ViewHolderNotes(ItemNoteBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun onBindViewHolder(holder: ViewHolderNotes, position: Int) {
        holder.bind(getItem(position))
    }

    inner class ViewHolderNotes (
        private val binding: ItemNoteBinding
    ):RecyclerView.ViewHolder(binding.root){
        fun bind(nOte: Note) {
            binding.tvTitle.text=nOte.title.toString()
            binding.description.text=nOte.desc.toString()
            itemView.setOnClickListener {
                click(nOte)
            }
            itemView.setOnLongClickListener {
                onLongClick(nOte)
                return@setOnLongClickListener false
            }
        }

    }
}
@SuppressLint("DiffUtilEquals")
private class DFUtilCallBack : DiffUtil.ItemCallback<Note>(){
    override fun areItemsTheSame(oldItem: Note, newItem: Note): Boolean {
        return oldItem.id==newItem.id
    }

    override fun areContentsTheSame(oldItem: Note, newItem: Note): Boolean {
        return oldItem==newItem
    }
}