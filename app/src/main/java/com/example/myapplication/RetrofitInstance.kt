package com.example.myapplication

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {
  private  val retrofit by lazy {
           Retrofit.Builder().baseUrl("https://jsonplaceholder.typicode.com/")
               .addConverterFactory(GsonConverterFactory.create())
               .client(OkHttpClient.Builder().build())
               .build()
    }
    val getInstance by lazy {
        retrofit.create(TodosService::class.java)
    }
}