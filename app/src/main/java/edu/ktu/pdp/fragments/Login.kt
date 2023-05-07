package edu.ktu.pdp.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.findNavController
import edu.ktu.pdp.R
import edu.ktu.pdp.databinding.FragmentLoginBinding


class Login : Fragment() {
    private lateinit var binding: FragmentLoginBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
            binding = FragmentLoginBinding.inflate(inflater, container, false)
            return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.loginBtn.setOnClickListener {
            val email = binding.loginEmailAddress.text.toString()
            val password = binding.loginPassword.text.toString()
            if (email == "manager" && password == "manager") {

            } else if (email == "worker" && password == "worker") {

            } else {
                Toast.makeText(context, "Wrong credentials", Toast.LENGTH_SHORT).show()
            }
        }
    }

}