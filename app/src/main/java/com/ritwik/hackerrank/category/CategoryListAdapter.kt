package com.ritwik.hackerrank.category

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.ritwik.hackerrank.databinding.CategoryCardBinding
import com.ritwik.hackerrank.network.Category

class CategoryListAdapter(private val clickListener: CategoryClickListener): ListAdapter<Category, CategoryListAdapter.ViewHolder>(DiffCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(CategoryCardBinding.inflate(
            LayoutInflater.from(parent.context)))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val category = getItem(position)
        holder.bind(category, clickListener)
    }


    class ViewHolder(private var binding: CategoryCardBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(category: Category, clickListener: CategoryClickListener){
            binding.category = category
            binding.executePendingBindings()
            binding.clickListener = clickListener
        }
    }

    companion object DiffCallback : DiffUtil.ItemCallback<Category>() {
        override fun areItemsTheSame(oldItem: Category, newItem: Category): Boolean {
            return oldItem === newItem
        }

        override fun areContentsTheSame(oldItem: Category, newItem: Category): Boolean {
            return oldItem.category_name == newItem.category_name
        }

    }
}

class CategoryClickListener(val clickListener: (category: Category) -> (Unit)){
    fun onClick(category: Category) = clickListener(category)
}

