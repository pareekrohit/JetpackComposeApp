package com.example.mycomposeapp.meal.viewModel

import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mycomposeapp.model.Category
import com.example.mycomposeapp.model.repository.MealRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MealViewModel(private val repository: MealRepository = MealRepository()) : ViewModel() {

    init {
        getMeal()
    }

    val mealState: MutableState<List<Category>> = mutableStateOf(emptyList<Category>())

    private fun getMeal() {
        viewModelScope.launch(Dispatchers.IO) {
            val mealsList = repository.getMealsList().categories
            mealState.value = mealsList
        }
    }


    /*private val _mealsList = MutableLiveData<List<Category>>()
    val mealsList: LiveData<List<Category>>
        get() = _mealsList*/


    /* fun getMealsList() {
         Log.d("ViewModel", "In ViewModel getMealList")
         viewModelScope.launch(Dispatchers.IO) {
             _mealsList.postValue(repository.getMealsList().categories)
             Log.d("ViewModel", "Got Meal List")
         }

         Log.d("ViewModel", "out of getMealList")
     }*/


}