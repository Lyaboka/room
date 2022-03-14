package com.example.roomdatabase.db.repository

import androidx.lifecycle.LiveData
import com.example.roomdatabase.db.dao.EmployeeDao
import com.example.roomdatabase.model.EmployeeModel

class EmployeeRealization(private val employeeDao: EmployeeDao) : EmployeeRepository {

    override val allEmployees: LiveData<List<EmployeeModel>>
        get() = employeeDao.getAllEmployees()

    override suspend fun insertEmployee(employeeModel: EmployeeModel, onSuccess: () -> Unit) {
        employeeDao.insert(employeeModel)
        onSuccess()
    }

    override suspend fun deleteEmployee(employeeModel: EmployeeModel, onSuccess: () -> Unit) {
        employeeDao.delete(employeeModel)
        onSuccess()
    }
}