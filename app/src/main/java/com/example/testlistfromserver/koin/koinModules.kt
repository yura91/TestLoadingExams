package com.example.testlistfromserver

import com.example.testlistfromserver.api.DevExamApi
import com.example.testlistfromserver.koin.createApi
import com.example.testlistfromserver.koin.createMoshi
import com.example.testlistfromserver.koin.provideOkHttpClient
import com.example.testlistfromserver.koin.provideRetrofit
import com.example.testlistfromserver.repository.*
import com.example.testlistfromserver.viewmodel.AuthViewModel
import com.example.testlistfromserver.viewmodel.MaskViewModel
import com.example.testlistfromserver.viewmodel.PostsViewModel
import org.koin.androidx.viewmodel.ext.koin.viewModel
import org.koin.dsl.module.module

val uiModule = module {
    viewModel { PostsViewModel(get()) }
    viewModel { AuthViewModel(get()) }
    viewModel { MaskViewModel(get()) }
}

val repositoryModule = module {
    single<AuthRepository> { AuthRepositoryImpl(get()) }
    single<DevExRepository> { DevExRepositoryImpl(get()) }
    single<MaskRepository> { MaskRepositoryImpl(get()) }
}

val remoteModule = module {
    single { provideOkHttpClient() }
    single { createMoshi() }
    single { provideRetrofit(get(), get()) }
    single { createApi<DevExamApi>(get()) }
}
