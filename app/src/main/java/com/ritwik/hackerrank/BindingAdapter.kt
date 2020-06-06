package com.ritwik.hackerrank

import android.view.View
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.ritwik.hackerrank.category.CategoryListAdapter
import com.ritwik.hackerrank.category.CategoryViewModel
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
fun bindQuestionsRecyclerView(
    recyclerView: RecyclerView,
    data: List<Question>?
) {
    val adapter = recyclerView.adapter as QuestionListAdapter
    adapter.submitList(data)
}

@BindingAdapter("apiStatus")
fun binStatusImageView(imageView: ImageView, data: CategoryViewModel.ApiStatus?) {
    when (data) {
        CategoryViewModel.ApiStatus.ERROR -> imageView.setImageResource(R.drawable.ic_connection_error)
        CategoryViewModel.ApiStatus.LOADING -> imageView.setImageResource(R.drawable.loading_img)
        CategoryViewModel.ApiStatus.DONE -> imageView.visibility = View.GONE
    }
}