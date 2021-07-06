package com.udacity.shoestore.screens.details

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentDetailsBinding

class DetailsFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {

        // Inflate view and obtain an instance of the binding class
        val binding: FragmentDetailsBinding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_details,
            container,
            false
        )

        // Save the shoe item and update the shoeList here
        binding.saveButton.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.action_save_detailsFragment_to_shoeListFragment))

        binding.cancelButton.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.action_cancel_detailsFragment_to_shoeListFragment))

        return binding.root
    }
}