package com.example.myposts.api

import com.example.myposts.models.Post
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

//where we define the multiple api endpoints
interface ApiInterface {
@GET("posts")
fun getPosts(postId: Int):Call<List<Post>> //always import call with retrofit 2
@GET("posts/{id}")
fun getPostById(@Path("id")postId:Int):Call<Post>
}
