package com.example.myapplication

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class PostAdapter(var posts: List<RedditPost>) : RecyclerView.Adapter<PostAdapter.PostViewHolder>() {

    inner class PostViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var title: TextView = itemView.findViewById(R.id.postTitle)
        var author: TextView = itemView.findViewById(R.id.postAuthor)
        var subreddit: TextView = itemView.findViewById(R.id.postSubreddit)
        var numComments: TextView = itemView.findViewById(R.id.postNumComments)
        var score: TextView = itemView.findViewById(R.id.postScore)
        var permalink: TextView = itemView.findViewById(R.id.postPermalink)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.post_item, parent, false)
        return PostViewHolder(view)
    }

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        val post = posts[position]
        holder.title.text = post.title
        holder.author.text = "Author: ${post.author}"
        holder.subreddit.text = "Subreddit: ${post.subreddit}"
        holder.numComments.text = "Comments: ${post.numComments}"
        holder.score.text = "Score: ${post.score}"
        holder.permalink.text = "Permalink: ${post.permalink}"
    }

    override fun getItemCount(): Int {
        return posts.size
    }

    fun updateData(newPosts: List<RedditPost>) {
        posts = newPosts
        notifyDataSetChanged()
    }
}
