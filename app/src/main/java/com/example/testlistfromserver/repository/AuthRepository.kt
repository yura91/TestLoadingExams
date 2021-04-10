package com.example.testlistfromserver.repository

import androidx.lifecycle.LiveData
import com.example.testlistfromserver.model.AuthResponse

interface AuthRepository {
    val auth: LiveData<AuthResponse>
    suspend fun authReq(phone: String)
}