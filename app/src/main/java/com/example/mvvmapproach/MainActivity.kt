package com.example.mvvmapproach

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.example.mvvmapproach.repositories.LoginRepository
import com.example.mvvmapproach.services.APIClient
import com.example.mvvmapproach.services.APIService
import com.example.mvvmapproach.viewmodels.LoginViewModel
import com.example.mvvmapproach.viewmodels.MyViewModelFactory

class MainActivity : AppCompatActivity() {
    lateinit var loginViewModel: LoginViewModel;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val apiService = APIClient.getInstance()
        val respository = LoginRepository(apiService)
        loginViewModel =
            ViewModelProvider(this, MyViewModelFactory(respository)).get(LoginViewModel::class.java)
    }
}