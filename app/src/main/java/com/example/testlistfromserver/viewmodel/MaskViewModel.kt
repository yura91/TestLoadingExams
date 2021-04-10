package com.example.testlistfromserver.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.testlistfromserver.model.PhoneMask
import com.example.testlistfromserver.repository.MaskRepository
import kotlinx.coroutines.launch

class MaskViewModel(
    private val repository: MaskRepository
) : ViewModel() {
    private val _mask: LiveData<PhoneMask> = repository.mask

    private val _loading: MutableLiveData<Boolean> = MutableLiveData()

    private val _error: MutableLiveData<Throwable> = MutableLiveData()

    val mask: LiveData<PhoneMask> get() = _mask

    fun getPhoneMask() {
        viewModelScope.launch {
            _loading.value = true
            try {
                repository.getPhoneMask()
//                _posts.value = listOf(user)
            } catch (t: Throwable) {
                Log.d("error", t.message!!)
//                _posts.value = emptyList()
//                _error.value = t
            } finally {
//                _loading.value = false
            }
        }
    }

    override fun onCleared() {
        super.onCleared()
    }
}