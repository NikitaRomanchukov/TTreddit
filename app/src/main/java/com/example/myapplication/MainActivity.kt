package com.example.myapplication

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var postAdapter: PostAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        postAdapter = PostAdapter(listOf())
        recyclerView.adapter = postAdapter

        val retrofit = Retrofit.Builder()
            .baseUrl("https://www.reddit.com/top/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val redditService = retrofit.create(RedditService::class.javaObjectType)

        val call = redditService.getTopPosts()

        call.enqueue(object : Callback<RedditResponse> {
            override fun onResponse(call: Call<RedditResponse>, response: Response<RedditResponse>) {
                if (response.isSuccessful) {
                    val redditResponse = response.body()
                    redditResponse?.data?.children?.let { showPosts(it) }
                }
            }

            override fun onFailure(call: Call<RedditResponse>, t: Throwable) {
                Log.e("MainActivity", "Failed to fetch data from Reddit API", t)
            }
        })
    }

    private fun showPosts(posts: List<RedditResponse.RedditChildren>) {
        postAdapter.updateData(posts.map { it.data })
    }
}
