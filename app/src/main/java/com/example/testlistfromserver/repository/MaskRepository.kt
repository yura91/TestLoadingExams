package com.example.testlistfromserver.repository

import com.example.testlistfromserver.model.PhoneMask

interface MaskRepository {
    suspend fun getPhoneMask(): PhoneMask
}