package com.example.testlistfromserver.repository

import com.example.testlistfromserver.api.DevExamApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class DevExRepositoryImpl(private val api: DevExamApi) : DevExRepository {
    override suspend fun devExAll() =
        withContext(Dispatchers.IO) {
            api.getPosts()
        }
}