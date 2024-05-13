package com.example.myapplication

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface RedditService {
    @GET("top.json")
    fun getTopPosts(
        @Query("limit") limit: Int = 10,
        @Query("after") after: String? = null)
    fun getTopPosts(): Call<RedditResponse>
}

