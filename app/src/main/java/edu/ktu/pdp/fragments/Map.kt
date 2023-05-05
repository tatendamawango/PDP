package edu.ktu.pdp.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import edu.ktu.pdp.R
import edu.ktu.pdp.databinding.FragmentMapBinding


class Map : Fragment() {
    private lateinit var binding: FragmentMapBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMapBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.view.setOnClickListener{
            val color = binding.view.background
            val isGreen = color.constantState == resources.getDrawable(R.color.green).constantState
            if (isGreen) {
                binding.view.setBackgroundResource(R.color.red)
            } else {
                binding.view.setBackgroundResource(R.color.green)
            }
        }
    }

}