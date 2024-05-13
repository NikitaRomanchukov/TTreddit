package com.example.myapplication

class RedditResponse (val data: RedditData)
{
    data class RedditData(
        val children: List<RedditChildren>
    )

    data class RedditChildren(
        val data: RedditPost
    )
}