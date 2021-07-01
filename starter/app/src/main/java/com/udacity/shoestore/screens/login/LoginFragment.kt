package com.udacity.shoestore.screens.login

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentLoginBinding

class LoginFragment : Fragment() {

    private lateinit var binding: FragmentLoginBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {

        // Inflate view and obtain an instance of the binding class
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_login,
            container,
            false
        )

        binding.loginButton.setOnClickListener { v: View ->
            val sharedPref = context?.getSharedPreferences(
                getString(R.string.preference_file_key), Context.MODE_PRIVATE
            )
            val onboardingFlag : Boolean? = sharedPref?.getBoolean(getString(R.string.onboarding_flag_key), false)
            if (onboardingFlag!!) {
                v.findNavController()
                    .navigate(LoginFragmentDirections.actionLoginFragmentToShoeListFragment())
            } else {
                v.findNavController()
                    .navigate(LoginFragmentDirections.actionLoginFragmentToWelcomeFragment())
            }
        }
        binding.singUpButton.setOnClickListener { v: View ->
            v.findNavController().navigate(LoginFragmentDirections.actionLoginFragmentToWelcomeFragment())
        }

        return binding.root
    }
}