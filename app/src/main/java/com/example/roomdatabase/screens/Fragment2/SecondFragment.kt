package com.example.roomdatabase.screens.Fragment2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.example.roomdatabase.APP
import com.example.roomdatabase.R
import com.example.roomdatabase.databinding.FragmentSecondBinding
import com.example.roomdatabase.model.EmployeeModel

class SecondFragment : Fragment() {

    private var binding: FragmentSecondBinding? = null
    private val mBinding get() = binding!!
    private lateinit var viewModel: SecondFragmentViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
            binding = FragmentSecondBinding.inflate(layoutInflater, container, false)
            return mBinding.root
    }

    override fun onStart() {
        super.onStart()
        init()
    }

    private fun init() {
        viewModel = ViewModelProvider(this).get(SecondFragmentViewModel::class.java)
        mBinding.addEmployee.setOnClickListener {
            val fio = mBinding.fioET.text.toString()
            val post = mBinding.postET.text.toString()
            val salary = mBinding.salaryET.text.toString()
            if(fio.isEmpty()) {
                Toast.makeText(APP,"Введите ФИО!", Toast.LENGTH_LONG).show()
            } else {
                viewModel.insert(EmployeeModel(fio = fio, post = post, salary = salary.toInt())){
                    APP.navController.navigate(R.id.action_secondFragment_to_startFragment)
                }
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }

}