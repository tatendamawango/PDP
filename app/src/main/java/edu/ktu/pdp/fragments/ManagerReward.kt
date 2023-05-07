package edu.ktu.pdp.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import edu.ktu.pdp.R
import edu.ktu.pdp.databinding.FragmentManagerRewardBinding
import java.util.Random

class ManagerReward : Fragment() {
    private lateinit var binding: FragmentManagerRewardBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentManagerRewardBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.managerRewardButton.setOnClickListener {
            binding.managerRewardCode.text = generateRandomCode()
        }
    }
    private fun generateRandomCode(): String {
        val random = Random()
        val code = StringBuilder()

        for (i in 0 until 6) {
            val digit = random.nextInt(10)
            code.append(digit)
        }
        return code.toString()
    }
}