package com.example.roomdatabase.screens.Fragment2

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.roomdatabase.REPOSITORY
import com.example.roomdatabase.model.EmployeeModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class Fragment2Model : ViewModel() {

    fun insert(employeeModel: EmployeeModel,onSuccess:() -> Unit) =
        viewModelScope.launch (Dispatchers.IO){
            REPOSITORY.insertEmployee(employeeModel) {
                onSuccess()
            }
        }
}