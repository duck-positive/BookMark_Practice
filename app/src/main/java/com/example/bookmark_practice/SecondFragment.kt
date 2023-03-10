package com.example.bookmark_practice

import android.os.Bundle
import android.os.SystemClock
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Chronometer
import android.widget.Chronometer.OnChronometerTickListener
import androidx.navigation.fragment.findNavController
import com.example.bookmark_practice.databinding.FragmentSecondBinding
import java.util.Timer
import java.util.TimerTask

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class SecondFragment : Fragment() {

    private var _binding: FragmentSecondBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentSecondBinding.inflate(inflater, container, false)




        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        var isWorking = false
        var pauseTime : Long = 0
        binding.buttonSecond.setOnClickListener {
            when(isWorking){
                true -> {
                    binding.textviewSecond.stop()
                    pauseTime = binding.textviewSecond.base - SystemClock.elapsedRealtime()
                    Log.d("time", "${SystemClock.elapsedRealtime() - binding.textviewSecond.base}")
                    isWorking = false
                }
                else -> {
                    binding.textviewSecond.base = SystemClock.elapsedRealtime() + pauseTime
                    binding.textviewSecond.start()
                    isWorking = true
                }
            }

            //findNavController().navigate(R.id.action_SecondFragment_to_FirstFragment)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}