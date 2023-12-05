package com.example.mvvmapproach.services

import com.example.mvvmapproach.models.LoginResponse
import com.example.mvvmapproach.models.RequestParam
import retrofit2.Response
import retrofit2.http.POST

interface APIService {
    @POST("user/login")
    suspend fun checkUserCredentials(request: RequestParam) : Response<LoginResponse>

}