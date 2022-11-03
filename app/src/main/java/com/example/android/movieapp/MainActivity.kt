package com.example.android.movieapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.android.movieapp.models.Movie
import com.example.android.movieapp.models.MovieResponse
import com.example.android.movieapp.services.MovieApiInterface
import com.example.android.movieapp.services.MovieApiService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<RecyclerView>(R.id.rv_movies_list).layoutManager = LinearLayoutManager(this)
        val r_m = findViewById<RecyclerView>(R.id.rv_movies_list)
        r_m.setHasFixedSize(true)
        getMovieData { movies : List<Movie> ->
            r_m.adapter = MovieAdapter(movies)
        }
    }

    private fun getMovieData(callback : (List<Movie>) -> Unit){
        val apiService = MovieApiService.getInstance().create(MovieApiInterface::class.java)
        apiService.getMovieList().enqueue(object : Callback<MovieResponse>{
          override fun onFailure(call: Call<MovieResponse>, t: Throwable){

            }

            override fun onResponse(
                call: Call<MovieResponse>,
                response: Response<MovieResponse>
            ) {
                return callback(response.body()!!.movies)
            }
        })
    }
}