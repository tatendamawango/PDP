package edu.ktu.pdp.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import edu.ktu.pdp.R
import edu.ktu.pdp.databinding.FragmentManagerReminderBinding

class ManagerReminder : Fragment() {
    private lateinit var binding: FragmentManagerReminderBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentManagerReminderBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.send.setOnClickListener {
            binding.message.text?.clear()
        }
    }

}