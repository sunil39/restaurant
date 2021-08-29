package com.cricbuzz.restaurant

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.cricbuzz.restaurant.data.util.Constants
import com.cricbuzz.restaurant.databinding.FragmentDetailsBinding
import com.cricbuzz.restaurant.presentation.viewmodel.RestaurantViewModel
/**
 * Created by Sunilkumar V on 29/08/21.
 * This fragment created for showing restaurants operating hours and details
 */
class FragmentDetails : Fragment() {
    private lateinit var viewModel: RestaurantViewModel
    private lateinit var fragmentDetailsBinding: FragmentDetailsBinding

    companion object {
        fun newInstance(bundle: Bundle): FragmentDetails {
            val fragment = FragmentDetails()
            fragment.arguments = bundle
            return fragment
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        fragmentDetailsBinding = FragmentDetailsBinding.inflate(layoutInflater)
        return fragmentDetailsBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = (activity as MainActivity).viewModel
        viewModel.getOperatingHours(requireArguments().getInt(Constants.RESTAURANT_ID.toString()))
            .observe(viewLifecycleOwner, {
                fragmentDetailsBinding.operatingHour = it
            })
    }

}