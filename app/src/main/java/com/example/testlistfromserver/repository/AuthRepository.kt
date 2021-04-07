package com.example.testlistfromserver.repository

import com.example.testlistfromserver.model.AuthResponse

interface AuthRepository {
    suspend fun authReq(phone: String, password: String = "devExam18"): AuthResponse
}