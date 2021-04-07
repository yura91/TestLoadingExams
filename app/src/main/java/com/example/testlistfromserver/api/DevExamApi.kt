package com.example.testlistfromserver.api

import com.example.testlistfromserver.model.AuthResponse
import com.example.testlistfromserver.model.PhoneMask
import com.example.testlistfromserver.model.Post
import kotlinx.coroutines.Deferred
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query


/**
 * @author Wellington Costa on 22/04/18.
 */
interface DevExamApi {

    @GET("api/v1/posts")
    fun getPosts(): Deferred<List<Post>>

    @GET("api/v1/phone_masks")
    fun getPhoneMasks(): Deferred<PhoneMask>

    @POST("api/v1/auth")
    fun authRequest(
        @Query("phone") phone: String?,
        @Query("password") password: String? = "devExam18"
    ): Deferred<AuthResponse>
}