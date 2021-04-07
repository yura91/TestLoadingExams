package com.example.testlistfromserver.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.testlistfromserver.model.Post
import com.example.testlistfromserver.repository.DevExRepository
import kotlinx.coroutines.launch

class PostsViewModel(
    private val repository: DevExRepository
) : ViewModel() {

    private val _posts: MutableLiveData<List<Post>> = MutableLiveData()

    private val _loading: MutableLiveData<Boolean> = MutableLiveData()

    private val _error: MutableLiveData<Throwable> = MutableLiveData()

    val posts: LiveData<List<Post>> get() = _posts

    val loading: LiveData<Boolean> get() = _loading

    val error: LiveData<Throwable> get() = _error

    fun getAllExams() {
        viewModelScope.launch {
            _loading.value = true
            try {
                _posts.value = repository.devExAll()
                _loading.value = false
            } catch (t: Throwable) {
                _posts.value = emptyList()
                _error.value = t
            } finally {
                _loading.value = false
            }
        }
    }
}