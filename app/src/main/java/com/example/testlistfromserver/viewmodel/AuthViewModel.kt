package com.example.testlistfromserver.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.testlistfromserver.model.AuthResponse
import com.example.testlistfromserver.repository.AuthRepository
import kotlinx.coroutines.launch

class AuthViewModel(
    private val repository: AuthRepository
) : ViewModel() {
    private val _auth: MutableLiveData<AuthResponse> = MutableLiveData()
    val auth: LiveData<AuthResponse> get() = _auth

    private val _error: MutableLiveData<Throwable> = MutableLiveData()
    val error: LiveData<Throwable> get() = _error
    private val _loading: MutableLiveData<Boolean> = MutableLiveData()

    fun auth(phone: String) {
        viewModelScope.launch {
            _loading.value = true
            try {
                val auth = repository.authReq(phone)
                _auth.value = auth
//                _posts.value = listOf(user)
            } catch (t: Throwable) {
//                _posts.value = emptyList()
//                _error.value = t
            } finally {
//                _loading.value = false
            }
        }
    }
}