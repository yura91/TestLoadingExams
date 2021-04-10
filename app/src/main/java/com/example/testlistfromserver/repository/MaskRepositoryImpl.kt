package com.example.testlistfromserver.repository

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.testlistfromserver.api.DevExamApi
import com.example.testlistfromserver.model.NetworkResponse
import com.example.testlistfromserver.model.PhoneMask
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class MaskRepositoryImpl(private val api: DevExamApi) : MaskRepository {
    private val _mask: MutableLiveData<PhoneMask> = MutableLiveData()
    override val mask: LiveData<PhoneMask> = _mask

    override suspend fun getPhoneMask() {
        withContext(Dispatchers.IO) {
            val maskResponse = api.getPhoneMasks()
            when (maskResponse) {
                is NetworkResponse.Success -> {
                    Log.d("TAG", "Success ${maskResponse.body.phoneMask}")
                    _mask.postValue(maskResponse.body)
                }
                is NetworkResponse.ApiError -> {
                    Log.d("TAG", "ApiError ${maskResponse.body.message}")
                }
                is NetworkResponse.NetworkError -> {
                    Log.d("TAG", "NetworkError")
                }

                is NetworkResponse.UnknownError -> {
                    Log.d("TAG", "UnknownError")
                }
            }
        }
    }
}