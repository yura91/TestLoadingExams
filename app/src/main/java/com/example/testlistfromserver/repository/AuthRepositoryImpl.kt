package com.example.testlistfromserver.repository

import android.util.Log
import com.example.testlistfromserver.api.DevExamApi
import com.example.testlistfromserver.model.NetworkResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class AuthRepositoryImpl(private val api: DevExamApi) : AuthRepository {
    override suspend fun authReq(phone: String) {
        withContext(Dispatchers.IO) {
            val authResponse = api.authRequest(phone).await()
            when (authResponse) {
                is NetworkResponse.Success -> {
                    Log.d("TAG", "Success ${authResponse.body.success}")
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