package com.kamrulhasan.affirmationapp

import android.annotation.SuppressLint
import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.kamrulhasan.affirmationapp.adapter.ItemAdapter
import com.kamrulhasan.affirmationapp.data.DataSource
import com.kamrulhasan.affirmationapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val myDataset = DataSource().loadAffirmation()
        val recyclerView = binding.rvStudentsInfo
        recyclerView ?. adapter = ItemAdapter(this, myDataset)
        recyclerView ?. setHasFixedSize(true)

//        val recyclerView = binding.rvParentRecycleView
//        recyclerView?.adapter = ItemAdapter(this, myDataset)
//        recyclerView ?. setHasFixedSize(true)

//        binding.tvShow.text = DataSource().loadAffirmation().size.toString()
    }
}