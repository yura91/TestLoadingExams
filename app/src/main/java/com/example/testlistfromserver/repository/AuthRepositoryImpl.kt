package com.example.testlistfromserver.repository

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.testlistfromserver.api.DevExamApi
import com.example.testlistfromserver.model.AuthResponse
import com.example.testlistfromserver.retrofitconverters.NetworkResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class AuthRepositoryImpl(private val api: DevExamApi) : AuthRepository {
    private val _auth: MutableLiveData<AuthResponse> = MutableLiveData()
    override val auth: LiveData<AuthResponse> = _auth

    override suspend fun authReq(phone: String) {
        withContext(Dispatchers.IO) {
            val authResponse = api.authRequest(phone).await()
            when (authResponse) {
                is NetworkResponse.Success -> {
                    Log.d("TAG", "Success ${authResponse.body.success}")
                    _auth.value = authResponse.body
                }
                is NetworkResponse.ApiError -> {
                    Log.d("TAG", "ApiError ${authResponse.body.message}")
                }
                is NetworkResponse.NetworkError -> {
                    Log.d("TAG", "NetworkError")
                }

                is NetworkResponse.UnknownError -> {
                    Log.d("TAG", "UnknownError")
                }
            }
        }
    }
}