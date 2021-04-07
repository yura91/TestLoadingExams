package com.example.testlistfromserver.model

data class PhoneMask(val phoneMask: String)

fun PhoneMask.toModel() = this.phoneMask