package com.udacity.shoestore.screens.login

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
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

        val sharedPref = context?.getSharedPreferences(
            getString(R.string.preference_file_key), Context.MODE_PRIVATE
        )
        val onboardingFlag : Boolean? = sharedPref?.getBoolean(getString(R.string.onboarding_flag_key), false)

        if (onboardingFlag!!) {
            val loginToShoeList = Navigation.createNavigateOnClickListener(R.id.action_loginFragment_to_shoeListFragment)
            binding.loginButton.setOnClickListener(loginToShoeList)
            binding.singUpButton.setOnClickListener(loginToShoeList)
        } else {
            val loginToWelcome = Navigation.createNavigateOnClickListener(R.id.action_loginFragment_to_welcomeFragment)
            binding.loginButton.setOnClickListener(loginToWelcome)
            binding.singUpButton.setOnClickListener(loginToWelcome)
        }

        return binding.root
    }
}