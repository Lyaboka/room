package com.example.roomdatabase.db.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.roomdatabase.model.EmployeeModel

@Dao
interface EmployeeDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(employeeModel: EmployeeModel)

    @Delete
    suspend fun delete(employeeModel: EmployeeModel)

    @Query("SELECT * from employees")
    fun getAllEmployees(): LiveData<List<EmployeeModel>>
}