package com.cricbuzz.restaurant.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.cricbuzz.restaurant.data.model.Review
import com.cricbuzz.restaurant.databinding.ReviewItemBinding
/**
 * Created by Sunilkumar V on 29/08/21.
 * Adapter class for listing reviews
 */
class ReviewAdapter : RecyclerView.Adapter<ReviewAdapter.ReviewViewHolder>() {

    private val callback = object : DiffUtil.ItemCallback<Review>() {
        override fun areItemsTheSame(oldItem: Review, newItem: Review): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Review, newItem: Review): Boolean {
            return oldItem == newItem
        }
    }

    val differ = AsyncListDiffer(this, callback)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ReviewViewHolder {
        val binding = ReviewItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ReviewViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ReviewViewHolder, position: Int) {
        val review = differ.currentList[position]
        holder.bind(review)
    }

    override fun getItemCount(): Int {
        return differ.currentList.size
    }

    inner class ReviewViewHolder(
        val binding: ReviewItemBinding
    ) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(review: Review) {
            binding.review = review
            binding.root.setOnClickListener {
                onItemClickListener?.let {
                    it(review)
                }
            }
        }
    }

    private var onItemClickListener: ((Review) -> Unit)? = null

    fun setOnItemClickListener(listener: (Review) -> Unit) {
        onItemClickListener = listener
    }
}









