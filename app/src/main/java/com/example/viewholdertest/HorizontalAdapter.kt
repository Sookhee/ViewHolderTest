package com.example.viewholdertest

import android.content.res.Resources
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import com.example.viewholdertest.databinding.ItemLongBinding
import com.example.viewholdertest.databinding.ItemShortBinding

class HorizontalAdapter : RecyclerView.Adapter<HorizontalAdapter.ViewHolder>() {

    lateinit var viewType: ViewType
    var items: List<BoxModel> = listOf()
    var onItemClick: ((selectedItem: BoxModel) -> Unit)? = null

    override fun getItemCount(): Int = items.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)

        return if (this.viewType == ViewType.SHORT) {
            ViewHolder(ItemLongBinding.inflate(inflater, parent, false))
        } else {
            ViewHolder(ItemShortBinding.inflate(inflater, parent, false))
        }
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(items[position], position, onItemClick)
    }

    class ViewHolder(private val binding: ViewDataBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(data: BoxModel, position: Int, onItemClick: ((selectedItem: BoxModel) -> Unit)?) {
            binding.setVariable(BR.content, data)
            binding.setVariable(BR.onItemClick, onItemClick)

            val layoutParams = binding.root.layoutParams as ViewGroup.MarginLayoutParams

            if (position == 0) {
                layoutParams.marginStart = 12.dp
            }

            binding.root.layoutParams = layoutParams
        }
    }

    companion object {
        enum class ViewType {
            SHORT, LONG
        }

        val Int.dp: Int
            get() = (this * Resources.getSystem().displayMetrics.density + 0.5f).toInt()
    }
}
