package com.example.roomdatabase

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.example.roomdatabase.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private var binding: ActivityMainBinding? = null
    val mBinding get() = binding!!
    lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mBinding.root)

        APP = this
        navController = Navigation.findNavController(this, R.id.nav_fragment)
    }

    override fun onDestroy() {
        super.onDestroy()
        binding = null
    }
}