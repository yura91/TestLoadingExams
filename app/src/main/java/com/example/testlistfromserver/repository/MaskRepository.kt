package com.example.testlistfromserver.repository

import androidx.lifecycle.LiveData
import com.example.testlistfromserver.model.PhoneMask

interface MaskRepository {
    val mask: LiveData<PhoneMask>
    suspend fun getPhoneMask()
}