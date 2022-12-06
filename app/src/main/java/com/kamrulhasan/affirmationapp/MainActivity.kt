package com.kamrulhasan.affirmationapp

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.widget.Toast
import androidx.appcompat.widget.SearchView
//import android.widget.SearchView.OnQueryTextListener
import androidx.recyclerview.widget.RecyclerView
import com.kamrulhasan.affirmationapp.adapter.ItemAdapter
import com.kamrulhasan.affirmationapp.data.DataSource
import com.kamrulhasan.affirmationapp.databinding.ActivityMainBinding
import com.kamrulhasan.affirmationapp.model.Affirmation
import java.util.*

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private var tempList: MutableList<Affirmation> = mutableListOf()
    private var searchList: MutableList<Affirmation> = mutableListOf()
    private lateinit var recyclerView: RecyclerView
    private val TAG = "MainActivity"

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        recyclerView = findViewById(R.id.rv_students_info)


        val myDataset = DataSource().loadAffirmation()
        tempList.addAll(myDataset)
        searchList.addAll(myDataset)
        recyclerView.adapter = ItemAdapter(this, tempList)
        recyclerView.setHasFixedSize(true)

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_item, menu)
        val item = menu?.findItem(R.id.search_item)
        Log.d(TAG, "taking item")
        val searchView = item?.actionView as SearchView
        Log.d(TAG, "after searchview")

        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                tempList.clear()
                val searchText = query!!.lowercase()
                Log.d(TAG, "text: $searchText")
                if (searchText.isNotEmpty()) {
                    searchList.forEach {
                        Log.d(TAG, "item: $it")
                        if (getString(it.personName).lowercase().contains(query)) {
                            tempList.add(it)
                        }
                    }
                } else {
                    tempList.addAll(searchList)
                }
                if (tempList.size == 0) {
                    val toast =
                        Toast.makeText(applicationContext, "Not Found Any Data", Toast.LENGTH_SHORT)
                    toast.show()
                }
                recyclerView.adapter?.notifyDataSetChanged()
                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                tempList.clear()
                val searchText = newText!!.lowercase()
                Log.d(TAG, "text: $searchText")
                if (searchText.isNotEmpty()) {
                    searchList.forEach {
                        Log.d(TAG, "item: $it")
                        if (getString(it.personName).lowercase().contains(newText)) {
                            tempList.add(it)
                        }
                    }
                } else {
                    tempList.addAll(searchList)
                }

                recyclerView.adapter?.notifyDataSetChanged()

                return false
            }

        })

        return super.onCreateOptionsMenu(menu)
    }
}