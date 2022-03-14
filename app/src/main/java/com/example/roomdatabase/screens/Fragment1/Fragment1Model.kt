package com.example.roomdatabase.screens.Fragment1

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.example.roomdatabase.REPOSITORY
import com.example.roomdatabase.db.EmployeeDatabase
import com.example.roomdatabase.db.repository.EmployeeRealization
import com.example.roomdatabase.model.EmployeeModel


class Fragment1Model(application: Application) : AndroidViewModel(application) {

    val context = application

    fun initDatabase() {
        val daoEmployee = EmployeeDatabase.getInstance(context).getEmployeeDao()
        REPOSITORY = EmployeeRealization(daoEmployee)
    }
    fun getAllEmployees() : LiveData<List<EmployeeModel>> {
        return REPOSITORY.allEmployees
    }
}