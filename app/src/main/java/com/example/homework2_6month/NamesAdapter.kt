package com.example.homework2_6month

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.homework2_6month.databinding.ItemRvBinding

class NamesAdapter(private val onClick: (pos: Int) -> Unit):
    RecyclerView.Adapter<NamesAdapter.ViewHolder>() {

    private val name = mutableListOf<NamesModel>()

    @SuppressLint("NotifyDataSetChanged")
    fun addNames(list: MutableList<NamesModel>){
        name.clear()
        name.addAll(list)
        notifyDataSetChanged()
    }

    @SuppressLint("NotifyDataSetChanged")
    fun deleteNames(pos: Int){
        name.removeAt(pos)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemRvBinding.inflate(LayoutInflater.from(parent.context),
                parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(name[position])
        holder.itemView.setOnLongClickListener {
            onClick(position)
            true
        }
    }

    override fun getItemCount(): Int = name.size

    inner class ViewHolder(private val binding: ItemRvBinding):
        RecyclerView.ViewHolder(binding.root) {
        fun bind(name: NamesModel){
            binding.txtName.text = name.name
        }
    }
}
