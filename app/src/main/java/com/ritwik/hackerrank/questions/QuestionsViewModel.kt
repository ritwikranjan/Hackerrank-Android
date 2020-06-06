package com.ritwik.hackerrank.questions

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ritwik.hackerrank.network.Category


class QuestionsViewModel(val category: Category, val application: Application): ViewModel() {

    private val _currentCategory = MutableLiveData<Category>()

    private val _questionLink = MutableLiveData<String?>()
    val questionLink: LiveData<String?>
        get() = _questionLink

    init {
        _currentCategory.value = category
        _questionLink.value = null
    }

    val adapter = QuestionListAdapter(ClickListener {
        _questionLink.value = it.question_link
    })

    fun onDoneLink(){
        _questionLink.value = null
    }



}