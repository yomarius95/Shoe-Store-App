package com.udacity.shoestore.screens.list

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.NavigationUI
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentShoeListBinding
import timber.log.Timber

class ShoeListFragment : Fragment() {

    private lateinit var binding: FragmentShoeListBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        // Inflate view and obtain an instance of the binding class
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_shoe_list,
            container,
            false
        )

        setHasOptionsMenu(true)

        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.overflow_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.loginFragment -> {
                this.findNavController().navigate(R.id.action_shoeListFragment_to_loginFragment)
                true
            }
            R.id.instructionsFragment -> {
                this.findNavController().navigate(R.id.action_shoeListFragment_to_instructionsFragment)
                true
            }
            else -> {
                super.onOptionsItemSelected(item)
            }
        }
    }
}