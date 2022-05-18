package com.example.mycomposeapp.model.repository

import com.example.mycomposeapp.model.MealModel
import com.example.mycomposeapp.model.retrofit.ApiService
import com.example.mycomposeapp.model.retrofit.RetrofitClient
import retrofit2.Call

class MealRepository(
    private val api: ApiService = RetrofitClient().buildApi(),
) {

    suspend fun getMealsList(): MealModel {
        return api.getMealList()
    }


}