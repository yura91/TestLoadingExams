package com.example.testlistfromserver.koin

import com.example.testlistfromserver.BuildConfig
import com.example.testlistfromserver.model.NetworkResponseAdapterFactory
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import com.squareup.moshi.Moshi
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

const val API_URL = "http://dev-exam.l-tech.ru"

internal fun provideOkHttpClient(): OkHttpClient {
    val client = OkHttpClient.Builder()

    if (BuildConfig.DEBUG) {
        val logging = HttpLoggingInterceptor()
        logging.level = HttpLoggingInterceptor.Level.BODY
        client.addInterceptor(logging)
    }

    return client.build()
}

internal fun createMoshi() = Moshi.Builder().build()

internal fun provideRetrofit(moshi: Moshi, okHttpClient: OkHttpClient) = Retrofit.Builder()
    .baseUrl(API_URL)
    .addCallAdapterFactory(CoroutineCallAdapterFactory())
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .addCallAdapterFactory(NetworkResponseAdapterFactory())
    .client(okHttpClient)
    .build()

internal inline fun <reified T> createApi(retrofit: Retrofit) = retrofit.create(T::class.java)
