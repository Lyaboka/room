package com.example.roomdatabase.screens.Fragment1

import android.content.ContentValues.TAG
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.example.roomdatabase.APP
import com.example.roomdatabase.R
import com.example.roomdatabase.adapter.EmployeeAdapter
import com.example.roomdatabase.databinding.Fragment1Binding
import java.lang.Exception

class Fragment1 : Fragment() {

lateinit var binding: Fragment1Binding
lateinit var recyclerView : RecyclerView
lateinit var adapter : EmployeeAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        try {
            binding = Fragment1Binding.inflate(layoutInflater, container, false)
            return binding.root
        } catch (e : Exception) {
            Log.e(TAG,"onCreateView", e)
            throw e
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
    }

    private fun init() {
        val viewModel = ViewModelProvider(this).get(Fragment1Model::class.java)
        viewModel.initDatabase()
        recyclerView = binding.rvEmpl
        adapter = EmployeeAdapter()
        recyclerView.adapter = adapter
        viewModel.getAllEmployees().observe(this, {listEmpl ->
            adapter.setList(listEmpl.asReversed())
        })

        binding.btnNext.setOnClickListener {
            APP.navController.navigate(R.id.action_fragment1_to_fragment2)
        }

    }

}