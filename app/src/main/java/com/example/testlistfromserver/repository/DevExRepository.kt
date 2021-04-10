package com.example.testlistfromserver.repository

import com.example.testlistfromserver.model.Error
import com.example.testlistfromserver.model.Post
import com.example.testlistfromserver.retrofitconverters.NetworkResponse


interface DevExRepository {
    suspend fun devExAll(): NetworkResponse<List<Post>, Error>
}