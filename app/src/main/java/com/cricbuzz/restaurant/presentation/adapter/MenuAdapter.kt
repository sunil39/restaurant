package com.cricbuzz.restaurant.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.cricbuzz.restaurant.data.model.MenuItems
import com.cricbuzz.restaurant.databinding.MenuItemBinding
/**
 * Created by Sunilkumar V on 29/08/21.
 * Adapter class for listing Menus
 */
class MenuAdapter : RecyclerView.Adapter<MenuAdapter.MenuViewHolder>() {


    private val callback = object : DiffUtil.ItemCallback<MenuItems>() {
        override fun areItemsTheSame(oldItem: MenuItems, newItem: MenuItems): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: MenuItems, newItem: MenuItems): Boolean {
            return oldItem == newItem
        }
    }

    val differ = AsyncListDiffer(this, callback)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MenuViewHolder {
        val binding = MenuItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MenuViewHolder(binding)
    }


    override fun onBindViewHolder(holder: MenuViewHolder, position: Int) {
        val menus = differ.currentList[position]
        holder.bind(menus)
    }

    override fun getItemCount(): Int {
        return differ.currentList.size
    }

    inner class MenuViewHolder(val binding: MenuItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(menuItems: MenuItems) {
            binding.menu = menuItems
            binding.price.text = "₹ ${menuItems.price.toString()}"
            Glide.with(binding.root.context).load(menuItems.image).into(binding.image)
        }
    }

    private var onItemClickListener: ((MenuItems) -> Unit)? = null

    fun setOnItemClickListener(listener: (MenuItems) -> Unit) {
        onItemClickListener = listener
    }


}









