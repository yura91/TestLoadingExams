package com.example.testlistfromserver.repository

import com.example.testlistfromserver.model.Post

interface DevExRepository {
    suspend fun devExAll(): List<Post>
}