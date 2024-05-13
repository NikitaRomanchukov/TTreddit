package com.example.myapplication

data class RedditPost(
    val title: String,
    val author: String,
    val subreddit: String,
    val createdUtc: Long,
    val numComments: Int,
    val score: Int,
    val permalink: String,
    val thumbnail: String
)
