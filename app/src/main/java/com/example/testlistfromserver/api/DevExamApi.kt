package com.example.testlistfromserver.api

import com.example.testlistfromserver.model.AuthResponse
import com.example.testlistfromserver.model.NetworkResponse
import com.example.testlistfromserver.model.PhoneMask
import com.example.testlistfromserver.model.Post
import kotlinx.coroutines.Deferred
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST


/**
 * @author Wellington Costa on 22/04/18.
 */
interface DevExamApi {

    @GET("api/v1/posts")
    fun getPosts(): Deferred<NetworkResponse<List<Post>, Error>>

    @GET("api/v1/phone_masks")
    fun getPhoneMasks(): Deferred<NetworkResponse<PhoneMask, Error>>

    @FormUrlEncoded
    @POST("api/v1/auth")
    fun authRequest(
        @Field("phone") phone: String?,
        @Field("password") password: String? = "devExam18"

    ): Deferred<NetworkResponse<AuthResponse, Error>>
}
