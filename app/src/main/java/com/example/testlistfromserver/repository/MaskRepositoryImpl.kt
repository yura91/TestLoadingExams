package com.example.testlistfromserver.repository

import com.example.testlistfromserver.api.DevExamApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class MaskRepositoryImpl(private val api: DevExamApi) : MaskRepository {
    override suspend fun getPhoneMask() =
        withContext(Dispatchers.IO) {
            api.getPhoneMasks().await()
        }
}