package com.example.testlistfromserver.repository

import com.example.testlistfromserver.api.DevExamApi
import com.example.testlistfromserver.model.AuthResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class AuthRepositoryImpl(private val api: DevExamApi) : AuthRepository {
    override suspend fun authReq(phone: String, password: String): AuthResponse =
        withContext(Dispatchers.IO) {
            api.authRequest(phone, password).await()
        }
}