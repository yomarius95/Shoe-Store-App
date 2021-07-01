package com.udacity.shoestore.screens.instruction

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentInstructionsBinding

class InstructionsFragment : Fragment() {

    private lateinit var binding: FragmentInstructionsBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {

        // Inflate view and obtain an instance of the binding class
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_instructions,
            container,
            false
        )

        binding.finishButton.setOnClickListener { v : View ->
            val sharedPref = context?.getSharedPreferences(
                getString(R.string.preference_file_key), Context.MODE_PRIVATE
            )
            with(sharedPref?.edit()) {
                this?.putBoolean(getString(R.string.onboarding_flag_key), true)
                this?.apply()
            }
            v.findNavController().navigate(InstructionsFragmentDirections.actionInstructionsFragmentToShoeListFragment())
        }

        return binding.root
    }
}