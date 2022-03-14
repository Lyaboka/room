package com.example.roomdatabase.db.repository

import androidx.lifecycle.LiveData
import com.example.roomdatabase.model.EmployeeModel

interface EmployeeRepository {
    val allEmployees : LiveData<List<EmployeeModel>>
    suspend fun insertEmployee(employeeModel: EmployeeModel,onSuccess:() -> Unit)
    suspend fun deleteEmployee(employeeModel: EmployeeModel,onSuccess:() -> Unit)
}