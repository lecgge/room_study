package com.xu.roomdemo01

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.xu.roomdemo01.entity.User

class MyAdapter(var context: Context,var list: List<User>) : RecyclerView.Adapter<MyAdapter.MyViewHolder>() {

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var firstName  = itemView.findViewById<TextView>(R.id.firstName)
        var lastName  = itemView.findViewById<TextView>(R.id.lastName)
        var age  = itemView.findViewById<TextView>(R.id.age)
        var id  = itemView.findViewById<TextView>(R.id.id)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        var view = LayoutInflater.from(context).inflate(R.layout.item, parent, false)
        var myViewHolder = MyViewHolder(view)
        return myViewHolder
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        var user = list.get(position)
        holder.firstName.text = user.firstName
        holder.lastName.text = user.lastName
        holder.age.text = user.age.toString()
        holder.id.text = user.id.toString()
    }

    override fun getItemCount() = list.size
}