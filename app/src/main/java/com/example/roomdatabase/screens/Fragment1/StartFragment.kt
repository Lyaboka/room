package com.example.roomdatabase.screens.Fragment1

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.recyclerview.widget.RecyclerView
import com.example.roomdatabase.APP
import com.example.roomdatabase.R
import com.example.roomdatabase.adapter.EmployeeAdapter
import com.example.roomdatabase.databinding.FragmentStartBinding
import com.example.roomdatabase.model.EmployeeModel

class StartFragment : Fragment() {

    private var binding: FragmentStartBinding? = null
    private val mBinding get() = binding!!

    private lateinit var recyclerView : RecyclerView
    private lateinit var adapter : EmployeeAdapter
    private lateinit var viewModel: StartFragmentViewModel
    private lateinit var observerList : Observer<List<EmployeeModel>>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentStartBinding.inflate(layoutInflater, container, false)
        return mBinding.root
    }

    override fun onStart() {
        super.onStart()
        init()
    }

    private fun init() {
        adapter = EmployeeAdapter()
        recyclerView = mBinding.rvEmpl
        recyclerView.adapter = adapter
        observerList = Observer {
            val list = it.asReversed()
            adapter.setList(list)
        }
        viewModel = ViewModelProvider(this).get(StartFragmentViewModel::class.java)
        viewModel.initDatabase()
        adapter.deleteEmpl.observe(this, Observer {
            viewModel.delete(it){

            }
        })
        viewModel.allEmployees!!.observe(this,observerList)
        mBinding.btnNext.setOnClickListener{
            APP.navController.navigate(R.id.action_startFragment_to_secondFragment)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
        viewModel.allEmployees!!.removeObserver(observerList)
        recyclerView.adapter = null
    }
}

