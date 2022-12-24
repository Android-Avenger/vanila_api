package com.example.myapplication

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import com.example.myapplication.ui.theme.MyApplicationTheme
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplicationTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                }
            }
        }

        RetrofitInstance.getInstance.fetchTodos().enqueue(object : Callback<Todos?> {
            override fun onResponse(call: Call<Todos?>, response: Response<Todos?>) {
                Toast.makeText(
                    this@MainActivity,
                    "success + ${response.body()?.get(0)?.title}",
                    Toast.LENGTH_LONG
                ).show()
            }

            override fun onFailure(call: Call<Todos?>, t: Throwable) {
                Toast.makeText(this@MainActivity, "failure", Toast.LENGTH_LONG).show()
                t.printStackTrace()

            }
        })
    }
}
