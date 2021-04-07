package com.example.testlistfromserver.model

data class Post(
    val id: Int, val title: String, val text: String,
    val image: String, val sort: Int, val date: String
)