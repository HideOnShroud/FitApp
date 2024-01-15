package com.hideonshroud.fitapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.hideonshroud.fitapp.ViewPagerAdapter
import androidx.viewpager2.widget.ViewPager2
import com.hideonshroud.fitapp.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val listOfFragments = listOf(HomeFragment(), LeaderboardFragment(), WorkoutsFragment(), ProfileFragment())
        binding.viewPager.adapter = ViewPagerAdapter(this,listOfFragments)
        binding.viewPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                when (position) {
                    0 -> binding.bottomNavigationView.menu.findItem(R.id.home).isChecked = true
                    1 -> binding.bottomNavigationView.menu.findItem(R.id.leaderboard).isChecked = true
                    2 -> binding.bottomNavigationView.menu.findItem(R.id.workouts).isChecked = true
                    3 -> binding.bottomNavigationView.menu.findItem(R.id.profile).isChecked = true

                }
            }
        })

        binding.bottomNavigationView.setOnItemSelectedListener {
            when(it.itemId){
                R.id.home ->{binding.viewPager.setCurrentItem(0, true)
                    return@setOnItemSelectedListener true}
                R.id.leaderboard -> {
                    binding.viewPager.setCurrentItem(1, true)
                    return@setOnItemSelectedListener true
                }
                R.id.workouts -> {
                    binding.viewPager.setCurrentItem(2, true)
                    return@setOnItemSelectedListener true
                }
                R.id.profile -> {
                    binding.viewPager.setCurrentItem(3, true)
                    return@setOnItemSelectedListener true
                }
                else ->{

                }

            }
            true
        }
    }

}