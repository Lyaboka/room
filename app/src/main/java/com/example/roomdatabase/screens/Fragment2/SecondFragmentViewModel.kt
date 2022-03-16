package com.example.roomdatabase.screens.Fragment2

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.roomdatabase.REPOSITORY
import com.example.roomdatabase.model.EmployeeModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class SecondFragmentViewModel(application: Application) : AndroidViewModel(application) {

    fun insert (empl : EmployeeModel, onSuccess: () -> Unit) =
        viewModelScope.launch (Dispatchers.Main) {
            REPOSITORY.insertEmployee(empl){
            onSuccess()
            }
        }
}