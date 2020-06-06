package com.ritwik.hackerrank.questions

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView import com.ritwik.hackerrank.databinding.QuestionListItemBinding
import com.ritwik.hackerrank.network.Question

class QuestionListAdapter(private val clickListener: ClickListener): ListAdapter<Question, QuestionListAdapter.ViewHolder>(DiffCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(QuestionListItemBinding.inflate(
            LayoutInflater.from(parent.context)))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val question = getItem(position)
        holder.bind(question, clickListener)
    }

    class ViewHolder(private var binding: QuestionListItemBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(question: Question, clickListener: ClickListener) {
            binding.question = question
            binding.executePendingBindings()
            binding.clickListener = clickListener
        }
    }

    companion object DiffCallback: DiffUtil.ItemCallback<Question>() {
        override fun areItemsTheSame(oldItem: Question, newItem: Question): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: Question, newItem: Question): Boolean {
            return oldItem.question_link == oldItem.question_link
        }
    }

}

class ClickListener(private val onClickListener: (question: Question) -> Unit){
    fun onClick(question: Question) = onClickListener(question)
}