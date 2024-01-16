package com.hideonshroud.fitapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.RadioGroup
import android.widget.TextView
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.room.Room

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch


class HomeFragment : Fragment() {
    private lateinit var mCalorieViewModel: CalorieViewModel
    private lateinit var calorieDao: CalorieDao
    private lateinit var ageEditTextView: TextView
    private lateinit var heightEditText: EditText
    private lateinit var weightEditText: EditText
    private lateinit var activityEditText: EditText
    private lateinit var sexRadio: RadioGroup
    private lateinit var calculateBMRButton:Button
    private lateinit var calShow: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootView = inflater.inflate(R.layout.fragment_home, container, false)
        mCalorieViewModel = ViewModelProvider(this).get(CalorieViewModel::class.java)
        // Find your views by ID
        ageEditTextView = rootView.findViewById(R.id.ageEditText)
        heightEditText = rootView.findViewById(R.id.heightEditText)
        activityEditText = rootView.findViewById(R.id.activityEditText)
        weightEditText = rootView.findViewById(R.id.weightEditText)
        calShow = rootView.findViewById(R.id.calShow)
        sexRadio = rootView.findViewById(R.id.sexRadio)

        calculateBMRButton = rootView.findViewById(R.id.calculateBMRButton)
        calculateBMRButton.setOnClickListener {
            var weight = weightEditText.text.toString().toDouble()
            var height = heightEditText.text.toString().toInt()
            var age = ageEditTextView.text.toString().toInt()
            var activity = activityEditText.text.toString().toInt()
            var bmr = 0.0
            if (sexRadio.checkedRadioButtonId == R.id.radioM){
                bmr = calculateBMRForMen(weight,height,age)
            }else if(sexRadio.checkedRadioButtonId == R.id.radioF){
                bmr = calculateBMRForWomen(weight,height,age)}else{
                Toast.makeText(requireContext(),"Select Sex",Toast.LENGTH_SHORT).show()
            }

            bmr = when (activity) {
                1 -> bmr
                2 -> bmr + 400
                3 -> bmr + 800
                4 -> bmr + 1600
                5 -> bmr + 2000
                else -> bmr
            }

            calShow.text = bmr.toString() + " Cals"
            insertDataToDatabase(bmr.toString())
        }

        return rootView
    }
    private fun insertDataToDatabase(bmr:String){
        val calorie = Calorie(0, bmr)
        mCalorieViewModel.addCalorie(calorie)
        Toast.makeText(requireContext(), "Success", Toast.LENGTH_SHORT)
    }
    fun calculateBMRForMen(weight: Double, height: Int, age: Int): Double {
        return 88.362 + (13.397 * weight) + (4.799 * height) - (5.677 * age)
    }

    fun calculateBMRForWomen(weight: Double, height: Int, age: Int): Double {
        return 447.593 + (9.247 * weight) + (3.098 * height) - (4.330 * age)
    }
}