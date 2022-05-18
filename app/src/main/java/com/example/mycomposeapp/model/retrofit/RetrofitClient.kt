package com.example.mycomposeapp.model.retrofit

import android.content.Context
import com.example.mycomposeapp.BuildConfig
import com.example.mycomposeapp.model.retrofit.Constants.Companion.BASE_URL
import okhttp3.OkHttpClient

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitClient {

    fun buildApi(): ApiService {
        /* val interceptor = HttpLoggingInterceptor()
         interceptor.setLevel(HttpLoggingInterceptor.Level.BODY)*/
        /*val client = OkHttpClient.Builder().addInterceptor().build()*/


        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiService::class.java)
    }
}