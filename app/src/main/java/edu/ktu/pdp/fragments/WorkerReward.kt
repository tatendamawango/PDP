package edu.ktu.pdp.fragments


import android.os.Bundle
import android.os.Handler
import android.text.Editable
import android.text.TextWatcher
import android.util.TypedValue
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AlphaAnimation
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

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.captureButton.visibility = View.INVISIBLE

        binding.captureButton.setOnClickListener {
            binding.workerRewardCode.text?.clear()

            val animation = AlphaAnimation(0.0f, 1.0f)
            animation.duration = 2000
            binding.captureButton.startAnimation(animation)
            binding.captureButton.text = "+1"
            binding.captureButton.setTextSize(TypedValue.COMPLEX_UNIT_SP, 24f)
            Handler().postDelayed({
                binding.captureButton.text = "Confirm"
                binding.captureButton.setTextSize(TypedValue.COMPLEX_UNIT_SP, 16f)
            }, 2000)
        }

        binding.workerRewardCode.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                if (s.toString().length == 6) {
                    binding.captureButton.visibility = View.VISIBLE
                } else {
                    binding.captureButton.visibility = View.INVISIBLE
                }
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                // Do nothing
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                // Do nothing
            }
        })
    }




}

