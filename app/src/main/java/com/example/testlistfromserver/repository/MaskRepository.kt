package com.example.testlistfromserver.repository

import com.example.testlistfromserver.model.NetworkResponse
import com.example.testlistfromserver.model.PhoneMask

interface MaskRepository {
    suspend fun getPhoneMask(): NetworkResponse<PhoneMask, Error>
}