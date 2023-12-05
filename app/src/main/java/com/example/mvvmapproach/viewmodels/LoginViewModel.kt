package com.example.mvvmapproach.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.mvvmapproach.models.LoginResponse
import com.example.mvvmapproach.models.RequestParam
import com.example.mvvmapproach.repositories.LoginRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class LoginViewModel constructor(val loginRepository: LoginRepository) : ViewModel() {
    var job: Job? = null
    val loginResp = MutableLiveData<LoginResponse>()
    val loading = MutableLiveData<Boolean>()
    val errorMessage = MutableLiveData<String>()
    fun getLoginResponse(request: RequestParam) {
        job = CoroutineScope(Dispatchers.IO).launch {
            val response = loginRepository.checkUserLogin(request)
            withContext(Dispatchers.Main) {
                if (response.isSuccessful) {
                    loginResp.postValue(response.body())
                    loading.value = false
                } else {
                    onError("Error : ${response.message()} ")
                }
            }

        }

    }

    private fun onError(message: String) {
        errorMessage.value = message
        loading.value = false
    }

}