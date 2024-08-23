package com.example.hellodr.Fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.hellodr.R
import com.example.hellodr.databinding.FragmentLoginBinding
import com.example.hellodr.databinding.FragmentRegisterBinding

class LoginFragment : Fragment() {

    lateinit var binding: FragmentLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_login, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentLoginBinding.bind(view)
        val navController = findNavController()

        binding.tvRegisterclick.setOnClickListener {
            navController.navigate(R.id.action_loginFragment_to_registerFragment)
        }

        binding.bLogin.setOnClickListener {
            navController.navigate(R.id.action_loginFragment_to_nav_graph)
        }
    }
}