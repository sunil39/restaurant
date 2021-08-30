package com.cricbuzz.restaurant.presentation.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.cricbuzz.restaurant.MainActivity
import com.cricbuzz.restaurant.data.util.Constants
import com.cricbuzz.restaurant.databinding.FragmentReviewBinding
import com.cricbuzz.restaurant.presentation.adapter.ReviewAdapter
import com.cricbuzz.restaurant.presentation.viewmodel.RestaurantViewModel
/**
 * Created by Sunilkumar V on 29/08/21.
 * This fragment created for listing restaurants reviews
 */
class FragmentReview : Fragment() {
    private lateinit var viewModel: RestaurantViewModel
    private lateinit var reviewAdapter: ReviewAdapter
    private lateinit var fragmentReviewBinding: FragmentReviewBinding

    companion object {
        fun newInstance(bundle: Bundle): FragmentReview {
            val fragment = FragmentReview()
            fragment.arguments = bundle
            return fragment
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        fragmentReviewBinding = FragmentReviewBinding.inflate(layoutInflater)
        return fragmentReviewBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = (activity as MainActivity).viewModel
        reviewAdapter = (activity as MainActivity).reviewAdapter
        reviewAdapter.setOnItemClickListener {

        }
        initRecyclerView()
        viewRestaurantList()
    }

    private fun viewRestaurantList() {
        viewModel.getReview(requireArguments().getInt(Constants.RESTAURANT_ID.toString()))
            .observe(viewLifecycleOwner, {
                reviewAdapter.differ.submitList(it)
            })
    }

    private fun initRecyclerView() {
        fragmentReviewBinding.review.apply {
            adapter = reviewAdapter
            layoutManager = LinearLayoutManager(activity)
        }

    }
}