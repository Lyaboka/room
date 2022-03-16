package com.example.roomdatabase.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "employees")
data class EmployeeModel (

    @PrimaryKey(autoGenerate = true)
    var id: Int = 0,

    @ColumnInfo
    var fio: String = "",

    @ColumnInfo
    var post: String = "",

    @ColumnInfo
    var salary: Int = 0
)