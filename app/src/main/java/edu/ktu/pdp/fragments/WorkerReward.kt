package edu.ktu.pdp.fragments


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import edu.ktu.pdp.databinding.FragmentWorkerRewardBinding

class WorkerReward : Fragment() {
    private lateinit var binding: FragmentWorkerRewardBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentWorkerRewardBinding.inflate(inflater, container, false)
        return binding.root
    }


}

