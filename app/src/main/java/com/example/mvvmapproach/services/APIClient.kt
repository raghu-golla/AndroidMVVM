package com.example.mvvmapproach.services

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object APIClient {
    var mHttpLoggingInterceptor = HttpLoggingInterceptor()
        .setLevel(HttpLoggingInterceptor.Level.BODY)

    var okHttpClient = OkHttpClient.Builder().addInterceptor(mHttpLoggingInterceptor).build()

    var retrofitAPIService: APIService? = null
    val BASE_URL = ""
    fun getInstance(): APIService {
        if (retrofitAPIService == null) {
            val retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
            retrofitAPIService = retrofit.create(APIService::class.java)
        }
        return retrofitAPIService!!
    }
}


