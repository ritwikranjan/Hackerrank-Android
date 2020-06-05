package com.ritwik.hackerrank

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.ritwik.hackerrank.category.CategoryListAdapter
import com.ritwik.hackerrank.network.Category
import com.ritwik.hackerrank.network.Question
import com.ritwik.hackerrank.questions.QuestionListAdapter

@BindingAdapter("listData")
fun bindRecyclerView(recyclerView: RecyclerView,
                     data: List<Category>?) {
    val adapter = recyclerView.adapter as CategoryListAdapter
    adapter.submitList(data)
}

@BindingAdapter("listDataQuestion")
fun bindQuestionsRecyclerView(recyclerView: RecyclerView,
                     data: List<Question>?) {
    val adapter = recyclerView.adapter as QuestionListAdapter
    adapter.submitList(data)
}