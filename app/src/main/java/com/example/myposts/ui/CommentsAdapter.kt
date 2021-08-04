package com.example.myposts.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.myposts.R
import com.example.myposts.models.Post

class CommentsAdapter(var commentsList: List<Post>):RecyclerView.Adapter<CommentsViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CommentsViewHolder {
var itemView=LayoutInflater.from(parent.context).inflate(R.layout.activity_comments,parent,false)
    return CommentsViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: CommentsViewHolder, position: Int) {
var currentComments=commentsList.get(position)
        holder.tvName.text=currentComments.name.toString()
        holder.tvEmail.text=currentComments.email.toString()
        holder.tvBody2.text=currentComments.body2





    }

    override fun getItemCount(): Int {
        return commentsList.size
    }

}
class CommentsViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
    var tvName=itemView.findViewById<TextView>(R.id.tvName)
    var tvEmail=itemView.findViewById<TextView>(R.id.tvEmail)
    var tvBody2=itemView.findViewById<TextView>(R.id.tvBody2)

}
