package com.hideonshroud.fitapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class ProfileFragment : Fragment() {
    private lateinit var calorieIntake:TextView
    private lateinit var mCalorieViewModel: CalorieViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val rootView = inflater.inflate(R.layout.fragment_profile, container, false)
        mCalorieViewModel = ViewModelProvider(this).get(CalorieViewModel::class.java)
        mCalorieViewModel.readAllData.observe(viewLifecycleOwner, Observer { calorie ->
            calorieIntake.text = calorie.toString()
        })

        calorieIntake = rootView.findViewById(R.id.calorieIntake)

        return rootView
    }


}