package com.cricbuzz.restaurant.presentation.fragment

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.KeyEvent
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import android.widget.TextView
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.cricbuzz.restaurant.MainActivity
import com.cricbuzz.restaurant.data.util.Constants
import com.cricbuzz.restaurant.databinding.FragmentRestaurantBinding
import com.cricbuzz.restaurant.presentation.adapter.RestaurantAdapter
import com.cricbuzz.restaurant.presentation.viewmodel.RestaurantViewModel
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
/**
 * Created by Sunilkumar V on 29/08/21.
 * This is the Entry(Home) Fragment of Navigation Components
 * This fragment created for listing and filtering restaurants
 */
class RestaurantFragment : Fragment() {
    private lateinit var viewModel: RestaurantViewModel
    private lateinit var restaurantAdapter: RestaurantAdapter
    private lateinit var fragmentRestaurantBinding: FragmentRestaurantBinding
    private lateinit var preference: SharedPreferences
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        fragmentRestaurantBinding = FragmentRestaurantBinding.inflate(layoutInflater)
        return fragmentRestaurantBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = (activity as MainActivity).viewModel
        preference = requireContext().getSharedPreferences(
            Constants.CREDENTIALS.toString(),
            Context.MODE_PRIVATE
        )
        restaurantAdapter = (activity as MainActivity).restaurantAdapter

        restaurantAdapter.setOnItemClickListener {
            val action =
                RestaurantFragmentDirections.actionRestaurantFragmentToInfoFragment(it.id!!)
            findNavController().navigate(action)
        }

        val initialized = preference.getBoolean(Constants.INITIALIZED.toString(), false)
        if (!initialized) {
            viewModel.resourceToDb()
            preference.edit().putBoolean(Constants.INITIALIZED.toString(), true).apply()
        }
        initRecyclerView()
        viewRestaurantList()
        setSearchView()
    }

    private fun viewRestaurantList() {
        viewModel.getRestaurant().observe(viewLifecycleOwner, {
            restaurantAdapter.differ.submitList(it)
        })
    }

    private fun initRecyclerView() {
        fragmentRestaurantBinding.restaurants.apply {
            adapter = restaurantAdapter
            layoutManager = LinearLayoutManager(activity)
        }
    }

    //search
    private fun setSearchView() {

        fragmentRestaurantBinding.searchIcon.setOnClickListener { showSearch() }
        fragmentRestaurantBinding.searchCancel.setOnClickListener { hideSearch() }
        fragmentRestaurantBinding.searchKeyword.setOnEditorActionListener { v: TextView?, actionId: Int, event: KeyEvent? ->
            viewSearchedRestaurant(fragmentRestaurantBinding.searchKeyword.text.toString())
            hideSearch()
            false
        }
        fragmentRestaurantBinding.searchKeyword.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                MainScope().launch {
                    delay(300)
                    viewSearchedRestaurant(s.toString())
                }
            }

            override fun afterTextChanged(s: Editable?) {}

        })
    }

    fun viewSearchedRestaurant(keyword: String) {
        viewModel.getSearchedRestaurant(keyword).observe(viewLifecycleOwner, {
            restaurantAdapter.differ.submitList(it)
        })
    }

    private fun showSearch() {
        fragmentRestaurantBinding.appName.visibility = View.GONE
        fragmentRestaurantBinding.searchIcon.visibility = View.GONE
        fragmentRestaurantBinding.searchSection.visibility = View.VISIBLE
        showKeyboard()
    }

    private fun hideSearch() {
        fragmentRestaurantBinding.appName.visibility = View.VISIBLE
        fragmentRestaurantBinding.searchIcon.visibility = View.VISIBLE
        fragmentRestaurantBinding.searchSection.visibility = View.GONE
        hideKeyboard()
    }


    private fun showKeyboard() {
        val inputMethodManager =
            requireActivity().getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        inputMethodManager.toggleSoftInputFromWindow(
            fragmentRestaurantBinding.searchKeyword.applicationWindowToken,
            InputMethodManager.SHOW_FORCED,
            0
        )
    }

    private fun hideKeyboard() {
        val imm =
            requireActivity().getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(fragmentRestaurantBinding.searchKeyword.windowToken, 0)
    }

}
















