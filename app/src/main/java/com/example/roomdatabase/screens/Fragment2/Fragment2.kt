package com.example.roomdatabase.screens.Fragment2

import android.content.ContentValues.TAG
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.example.roomdatabase.APP
import com.example.roomdatabase.R
import com.example.roomdatabase.databinding.Fragment2Binding
import com.example.roomdatabase.model.EmployeeModel
import java.lang.Exception

class Fragment2 : Fragment() {

    lateinit var binding: Fragment2Binding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        try {
            binding = Fragment2Binding.inflate(layoutInflater, container, false)
            return binding.root
        } catch (e: Exception) {
            Log.e(TAG,"OnCreateView", e)
            throw e
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
    }

    private fun init() {
        val viewModel = ViewModelProvider(this).get(Fragment2Model::class.java)
        binding.addEmployee.setOnClickListener {
            val fio = binding.fioET.text.toString()
            val post = binding.postET.text.toString()
            val salary = binding.salaryET.text.toString()
            viewModel.insert(EmployeeModel(fio = fio, post = post, salary = salary.toInt())){}
            APP.navController.navigate(R.id.action_fragment2_to_fragment1)
        }
        binding.btnBack.setOnClickListener {
            APP.navController.navigate(R.id.action_fragment2_to_fragment1)
        }
    }

}