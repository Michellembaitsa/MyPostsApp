package com.example.myposts.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myposts.PostsRvAdapter
import com.example.myposts.R
import com.example.myposts.api.ApiClient
import com.example.myposts.api.ApiInterface
import com.example.myposts.models.Post
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    lateinit var rvPosts:RecyclerView //catings the recycler view
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        rvPosts=findViewById(R.id.rvPosts)
        rvPosts.layoutManager=LinearLayoutManager(baseContext)//without a layout manager, recycler view cannot display


        fetchPosts()
    }
    fun fetchPosts(){
        var retrofit= ApiClient.buildApiClient(ApiInterface::class.java)
        var postId = 0
        var request=retrofit.getPosts(postId) //getposts() is a func in the apiInterface
        request.enqueue(object : Callback<List<Post>> { //the callback is anonymous implement two classes
            override fun onResponse(call: Call<List<Post>>, response: Response<List<Post>>) {
                if(response.isSuccessful) {
                    var postList = response.body()!!
                    if(postList!=null){
                    var postAdapter = PostsRvAdapter(postList,baseContext)
                    rvPosts.adapter = postAdapter

                }
                    Toast.makeText(baseContext, "${postList!!.size} posts", Toast.
                    LENGTH_LONG).show()
                // Toast.makeText(baseContext,postList!!.size.toString(),Toast.LENGTH_LONG).show()
                    var postDate= mutableListOf<Post>()
                    for (x in 1..postList.size){
                        postDate.add(Post(3,85,"Developer","Info not available"))
                    }
                }
            }

            override fun onFailure(call: Call<List<Post>>, t: Throwable) {
        Toast.makeText(baseContext,t.message,Toast.LENGTH_LONG).show()            }
        })
    }
}