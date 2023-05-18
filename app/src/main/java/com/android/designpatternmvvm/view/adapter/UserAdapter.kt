package com.android.designpatternmvvm.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.android.designpatternmvvm.databinding.ItemUserBinding
import com.android.designpatternmvvm.model.getAllUserItem

class UserAdapter(var listUser: List<getAllUserItem>?) :
    RecyclerView.Adapter<UserAdapter.ViewHolder>() {

    class ViewHolder(var binding: ItemUserBinding) : RecyclerView.ViewHolder(binding.root) {
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = ItemUserBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binding.tvNama.text = listUser!![position].name
        holder.binding.tvAmalat.text = listUser!![position].address
        holder.binding.tvUmur.text = listUser!![position].age.toString()
    }

    override fun getItemCount(): Int {
        return listUser!!.size
    }

}