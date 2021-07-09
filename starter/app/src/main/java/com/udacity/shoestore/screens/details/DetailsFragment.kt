package com.udacity.shoestore.screens.details

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.SharedViewModel
import com.udacity.shoestore.databinding.FragmentDetailsBinding

class DetailsFragment : Fragment() {

    private val viewModel: SharedViewModel by activityViewModels()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {

        // Inflate view and obtain an instance of the binding class
        val binding: FragmentDetailsBinding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_details,
            container,
            false
        )

        binding.viewModel = viewModel
        binding.lifecycleOwner = this

        // Save the shoe item
        binding.saveButton.setOnClickListener { v: View ->
            if (viewModel.validateData()) {
                v.findNavController().navigate(R.id.action_save_detailsFragment_to_shoeListFragment)
            } else {
                Toast.makeText(context, "Invalid data!", Toast.LENGTH_SHORT).show()
            }
        }

        binding.cancelButton.setOnClickListener { v: View ->
            v.findNavController().navigate(R.id.action_cancel_detailsFragment_to_shoeListFragment)
            viewModel.onCancel()
        }
        return binding.root
    }
}