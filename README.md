Creating a simple application from top reddit

`PostAdapter` introduces an adapter for RecyclerView that binds Reddit post list data to UI elements, updating them as needed, and using the PostViewHolder internal class to efficiently control the presentation of each lst item

ReditPost represents the `RedditPost` data class, which is a model for storing information about a Reddit post, including title, author name, subsection name, creation time (in Unix time format), number of comments, rating, post link, and thumbnail URL.

RedditResponse contains data about Reddit posts. Inside `RedditResponse` there is a nested class `RedditData` containing a list of `children`. Each child element is represented by a nested `RedditChildren` class, which contains data about the Reddit post, represented in the `RedditPost` class.

`RedditService` is used to interact with the Reddit API using the Retrofit library. The `getTopPosts()` method makes a GET request to the "top.json" resource and returns a list of top Reddit posts as a `Call<RedditResponse>` object.

`MainActivity` is used to get data about top Reddit posts (using Retrofit) and display them in RecyclerView. When the data is successfully received, the `showPosts()` method is called to update the list of posts in the adapter. If there is an error when receiving data, an error message is displayed in the logs.
