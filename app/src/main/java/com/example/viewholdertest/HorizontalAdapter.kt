package com.example.viewholdertest

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.viewholdertest.databinding.ItemLongBinding

class HorizontalAdapter : RecyclerView.Adapter<HorizontalAdapter.ViewHolder>() {

    var items: List<String> = listOf()

    override fun getItemCount(): Int = items.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        return ViewHolder(ItemLongBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(items[position])
    }

    class ViewHolder(private val binding: ItemLongBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(data: String) {
            binding.content = data

            itemView.setOnClickListener { Toast.makeText(itemView.context, "TOAST: $data", Toast.LENGTH_SHORT).show() }
        }
    }
}