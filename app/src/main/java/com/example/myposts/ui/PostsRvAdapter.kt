package com.example.myposts

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.example.myposts.models.Post
import com.example.myposts.ui.ViewPostActivity

class PostsRvAdapter(var postList:List<Post>, var context:Context):RecyclerView.Adapter<ViewHolderPost>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderPost {
        var itemView=LayoutInflater.from(parent.context).inflate(R.layout.post_item,parent,false)
        return  ViewHolderPost(itemView)

    }

    override fun onBindViewHolder(holder: ViewHolderPost, position: Int) {
        var currentPost=postList.get(position)
        holder.tvUserId.text=currentPost.userId.toString()
        holder.tvId.text=currentPost.id.toString()
        holder.tvTitle.text=currentPost.title
        holder.tvBody.text=currentPost.body
        holder.cvPost.setOnClickListener {
            var intent=Intent(context,ViewPostActivity::class.java)
            intent.putExtra("POST_ID",currentPost.id)
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
    return postList.size
    }
}
class ViewHolderPost(itemView:View):RecyclerView.ViewHolder(itemView){
    var tvUserId=itemView.findViewById<TextView>(R.id.tvUserId)
    var tvId=itemView.findViewById<TextView>(R.id.tvId)
    var tvTitle=itemView.findViewById<TextView>(R.id.tvTitle)
    var tvBody=itemView.findViewById<TextView>(R.id.tvBody)
    var cvPost=itemView.findViewById<CardView>(R.id.cvPosts)
}