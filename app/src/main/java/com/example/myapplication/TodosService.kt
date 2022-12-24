package com.example.myapplication

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.http.GET

interface TodosService {
      @GET("todos")
      fun fetchTodos():Call<Todos>
}