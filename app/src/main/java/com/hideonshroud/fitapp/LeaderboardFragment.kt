package com.hideonshroud.fitapp

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider

class LeaderboardFragment : Fragment() {
    private lateinit var textView:TextView
    private lateinit var viewModel: RetroViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val rootView = inflater.inflate(R.layout.fragment_leaderboard, container, false)
        textView = rootView.findViewById(R.id.textView8)
        val repository = Repository()
        val viewModelFactory = RetroViewFactory(repository)
        viewModel = ViewModelProvider(this, viewModelFactory).get(RetroViewModel::class.java)
        viewModel.getPost()
        viewModel.myResponse.observe(viewLifecycleOwner) { response ->
            if (response.isSuccessful) {
                Log.d("Id", response.body()?.id.toString())
                textView.text = response.body()?.title ?: "Response body is null"
            } else {
                textView.text = response.code().toString()
            }
        }

        return rootView
    }


}