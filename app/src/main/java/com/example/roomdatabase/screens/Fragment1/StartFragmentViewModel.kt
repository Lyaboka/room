package com.example.roomdatabase.screens.Fragment1

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.roomdatabase.REPOSITORY
import com.example.roomdatabase.db.EmployeeDatabase
import com.example.roomdatabase.db.repository.EmployeeRealization
import com.example.roomdatabase.model.EmployeeModel
import io.reactivex.internal.operators.single.SingleDoOnSuccess
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class StartFragmentViewModel(application: Application) : AndroidViewModel(application) {
    var allEmployees : LiveData<List<EmployeeModel>>? = null
    private val context = application

    fun initDatabase(){
        val dao = EmployeeDatabase.getInstance(context).getEmployeeDao()
        REPOSITORY = EmployeeRealization(dao)
        allEmployees = REPOSITORY.allEmployees
    }
    fun delete (empl: EmployeeModel, onSuccess: () -> Unit) =
        viewModelScope.launch (Dispatchers.Main) {
            REPOSITORY.deleteEmployee(empl) {
                onSuccess()
            }
        }
}
