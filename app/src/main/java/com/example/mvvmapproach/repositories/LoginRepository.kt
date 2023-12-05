package com.example.mvvmapproach.repositories

import com.example.mvvmapproach.models.RequestParam
import com.example.mvvmapproach.services.APIService

class LoginRepository constructor(private val apiService: APIService) {

    suspend fun checkUserLogin(body: RequestParam) = apiService.checkUserCredentials(body)

}