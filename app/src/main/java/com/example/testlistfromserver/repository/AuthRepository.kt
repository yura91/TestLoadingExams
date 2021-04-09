package com.example.testlistfromserver.repository

interface AuthRepository {
    suspend fun authReq(phone: String)
}