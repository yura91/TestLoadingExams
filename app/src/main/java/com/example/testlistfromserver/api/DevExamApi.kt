package com.example.testlistfromserver.api

import com.example.testlistfromserver.model.*
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
    suspend fun getPosts(): NetworkResponse<List<Post>, Error>

    @GET("api/v1/phone_masks")
    suspend fun getPhoneMasks(): NetworkResponse<PhoneMask, Error>

    @FormUrlEncoded
    @POST("api/v1/auth")
    suspend fun authRequest(
        @Field("phone") phone: String?,
        @Field("password") password: String? = "devExam18"

    ): Deferred<NetworkResponse<AuthResponse, Error>>
}
