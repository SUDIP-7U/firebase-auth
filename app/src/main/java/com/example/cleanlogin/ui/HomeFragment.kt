package com.example.cleanlogin.ui

import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.findNavController
import com.example.cleanlogin.BaseFragment
import com.example.cleanlogin.R
import com.example.cleanlogin.databinding.FragmentHomeBinding

class HomeFragment : BaseFragment<FragmentHomeBinding>(FragmentHomeBinding::inflate) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

     binding.home.setOnClickListener {

         findNavController().navigate(R.id.action_homeFragment_to_loginFragment)

     }

    }

}