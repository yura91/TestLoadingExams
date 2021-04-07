package com.example.testlistfromserver.model

class AllPostsResponse {
    val postsList: List<Post> = ArrayList()
}

fun AllPostsResponse.toModel() = this.postsList