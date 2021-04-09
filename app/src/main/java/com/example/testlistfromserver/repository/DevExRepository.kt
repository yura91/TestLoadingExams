package com.example.testlistfromserver.repository

import com.example.testlistfromserver.model.NetworkResponse
import com.example.testlistfromserver.model.Post

interface DevExRepository {
    suspend fun devExAll(): NetworkResponse<List<Post>, Error>
}