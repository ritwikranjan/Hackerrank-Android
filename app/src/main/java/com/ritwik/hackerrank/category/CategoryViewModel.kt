package com.ritwik.hackerrank.category

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ritwik.hackerrank.network.Api
import com.ritwik.hackerrank.network.Category
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class CategoryViewModel: ViewModel(){

    enum class ApiStatus { LOADING, ERROR, DONE }

    private val viewModelJob = Job()
    private val coroutineScope = CoroutineScope(viewModelJob + Dispatchers.Main)

    val adapter = CategoryListAdapter(CategoryClickListener {
        _navigateToQuestions.value = it
    })

    private var _status = MutableLiveData<ApiStatus>()
    val status: LiveData<ApiStatus>
        get() = _status

    private val _categories = MutableLiveData<List<Category>>()
    val categories: LiveData<List<Category>>
        get() = _categories

    private val _navigateToQuestions = MutableLiveData<Category?>()
    val navigateToQuestions: LiveData<Category?>
        get() = _navigateToQuestions

    init {
        getCategories()
        _navigateToQuestions.value = null
    }

    private fun getCategories(){
        coroutineScope.launch{
            val getCategoriesDeferred = Api.retrofitService.getCategoryListAsync()
            try {
                _status.value = ApiStatus.LOADING
                val categoryList = getCategoriesDeferred.await()
                _categories.value = categoryList
                _status.value = ApiStatus.DONE
            }catch (e: Exception){
                _status.value = ApiStatus.ERROR
                _categories.value = ArrayList()
            }
        }
    }

    fun onDoneNavigation(){
        _navigateToQuestions.value = null
    }


    override fun onCleared() {
        super.onCleared()
        viewModelJob.cancel()
    }


}