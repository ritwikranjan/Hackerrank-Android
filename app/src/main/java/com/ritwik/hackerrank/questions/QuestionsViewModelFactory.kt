package com.ritwik.hackerrank.questions

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.ritwik.hackerrank.network.Category


class QuestionsViewModelFactory(private val category: Category,
                                private val application: Application): ViewModelProvider.Factory{
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(QuestionsViewModel::class.java)){
            return QuestionsViewModel(category, application) as T
        }
        else throw IllegalArgumentException()
    }

}