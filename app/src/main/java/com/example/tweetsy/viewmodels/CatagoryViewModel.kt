package com.example.tweetsy.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.tweetsy.repository.TweetRepository
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

class CatagoryViewModel @Inject constructor(private val repository: TweetRepository) : ViewModel() {

    val category: StateFlow<List<String>>
        get() = repository.catagory

    init {
        viewModelScope.launch {
            repository.getCatagories()
        }
    }

}