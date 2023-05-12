package edu.ktu.pdp.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import edu.ktu.pdp.R
import edu.ktu.pdp.databinding.FragmentLoginBinding


class Login : Fragment() {
    private lateinit var binding: FragmentLoginBinding
    private lateinit var navController: NavController

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentLoginBinding.inflate(inflater, container, false)

        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = Navigation.findNavController(requireActivity(), R.id.fragment_layout)

        val email = binding.loginEmailAddress.text.toString()
        val password = binding.loginPassword.text.toString()

        if (email == "manager" && password == "manager") {
            navController.navigate(R.id.action_login_to_nav_graph_manager)
        } else if (email == "worker" && password == "worker") {
            navController.navigate(R.id.action_login_to_nav_graph)
        } else {
            Toast.makeText(context, "Wrong credentials", Toast.LENGTH_SHORT).show()
        }
    }




}