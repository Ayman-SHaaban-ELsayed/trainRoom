package com.ayman.roomdatabasetraining.fragment.listusers

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ayman.roomdatabasetraining.R
import com.ayman.roomdatabasetraining.data.User
import kotlinx.android.synthetic.main.my_custom_row.view.*

class ListUsersAdapter : RecyclerView.Adapter<ListUsersAdapter.AymanViewHolder>() {
    private var userList = emptyList<User>()

    class AymanViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AymanViewHolder {
        return AymanViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.my_custom_row, parent, false)
        )
    }

    override fun onBindViewHolder(holder: AymanViewHolder, position: Int) {
        val currentItem = userList[position]
        holder.itemView.id_txt.text = currentItem.id.toString()
        holder.itemView.first_name_txt.text = currentItem.FirstName
        holder.itemView.second_name_txt.text = currentItem.LastName
        holder.itemView.age_txt.text = currentItem.age.toString()
    }

    fun setData(user: List<User>) {
        this.userList = user
        notifyDataSetChanged()

    }

    override fun getItemCount(): Int {
        return userList.size
    }
}

























