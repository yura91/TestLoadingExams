package com.example.testlistfromserver.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class PhoneMask(
    @Json(name = "phoneMask")
    val phoneMask: String
)

@JsonClass(generateAdapter = true)
data class Error(
    @Json(name = "status")
    val status: String,

    @Json(name = "message")
    val message: String
)