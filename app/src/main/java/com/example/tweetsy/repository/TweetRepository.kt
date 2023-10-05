package com.example.tweetsy.repository

import com.example.tweetsy.api.TweetsyInterfaceApi
import com.example.tweetsy.models.TweetListItem
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

class TweetRepository @Inject constructor(private val tweetsyInterfaceApi: TweetsyInterfaceApi) {

    private val _catagories = MutableStateFlow<List<String>>(emptyList())
    val catagory: StateFlow<List<String>>
        get() = _catagories

    private val _tweets = MutableStateFlow<List<TweetListItem>>(emptyList())
    val tweets: StateFlow<List<TweetListItem>>
        get() = _tweets


    suspend fun getCatagories() {

        val response = tweetsyInterfaceApi.getCategories()
        if (response.isSuccessful && response.body() != null) {
            _catagories.emit(response.body()!!)
        }

    }

    suspend fun getTweets(catagory: String) {

        val response = tweetsyInterfaceApi.getTweets(catagory)
        if (response.isSuccessful && response.body() != null) {
            _tweets.emit(response.body()!!)
        }

    }

}