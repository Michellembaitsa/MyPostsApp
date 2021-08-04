package com.example.myposts.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myposts.R
import com.example.myposts.api.ApiClient
import com.example.myposts.api.ApiInterface
import com.example.myposts.models.Post
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CommentsActivity : AppCompatActivity() {
    var postId=0

    lateinit var rvComments:RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_comments)
        rvComments=findViewById(R.id.rvComments)
rvComments.layoutManager=LinearLayoutManager(baseContext)

        fetchPosts()
    }
    fun fetchPosts(){
        var retrofit= ApiClient.buildApiClient(ApiInterface::class.java)
        var postId = 0
        var request=retrofit.getPosts(postId) //getposts() is a func in the apiInterface
        request.enqueue(object : Callback<List<Comments>> { //the callback is anonymous implement two classes
            override fun onResponse(
                call: Call<List<Comments>>,
                response: Response<List<Comments>>
            ) {
                if(response.isSuccessful) {
                    var commentList = response.body()!!

                        var commentsAdapter = CommentsAdapter(commentList)
                        rvComments.adapter = commentsAdapter


                    Toast.makeText(baseContext, "${commentList!!.size} posts", Toast.
                    LENGTH_LONG).show()
                    // Toast.makeText(baseContext,postList!!.size.toString(),Toast.LENGTH_LONG).show()
                    var postDate= mutableListOf<Post>()
                    for (x in 1..commentList.size){
                        postDate.add(Post(3,85,"Developer","Info not available"))
                    }
                }
            }

            override fun onFailure(call: Call<List<Comments>>, t: Throwable) {
                Toast.makeText(baseContext,t.message,Toast.LENGTH_LONG).show()            }
        })
    }



    }

private fun <T> Call<T>.enqueue(callback: Callback<List<Comments>>) {

}
