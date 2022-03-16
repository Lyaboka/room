package com.example.roomdatabase.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.roomdatabase.db.dao.EmployeeDao
import com.example.roomdatabase.model.EmployeeModel

@Database(entities = [EmployeeModel::class], version = 1)
abstract class EmployeeDatabase : RoomDatabase() {

    abstract fun getEmployeeDao() : EmployeeDao

    companion object{
        @Volatile
        private var database : EmployeeDatabase ?= null

        @Synchronized
        fun getInstance(context: Context): EmployeeDatabase {
            return if (database == null) {
                database = Room.databaseBuilder(context,EmployeeDatabase::class.java, "db").build()
                database as EmployeeDatabase
            }
            else database as EmployeeDatabase
        }
    }
}