package com.example.mycomposeapp.model.retrofit

import com.example.mycomposeapp.model.MealModel
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {

    @GET("categories.php")
    suspend fun getMealList(): MealModel

}