package com.example.tweetsy.repository

import com.example.tweetsy.api.TweetsyInterfaceApi
import com.example.tweetsy.models.TweetListItem
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

class TweetRepository @Inject constructor(private val tweetsyInterfaceApi: TweetsyInterfaceApi) {

    private val _category = MutableStateFlow<List<String>>(emptyList())
    val category: StateFlow<List<String>>
        get() = _category

    private val _tweets = MutableStateFlow<List<TweetListItem>>(emptyList())
    val tweets: StateFlow<List<TweetListItem>>
        get() = _tweets


    suspend fun getCategories() {

        val response = tweetsyInterfaceApi.getCategories()
        if (response.isSuccessful && response.body() != null) {
            _category.emit(response.body()!!.distinct())
        }

    }

    suspend fun getTweets(category: String) {

        val response = tweetsyInterfaceApi.getTweets("tweets[?(@.category==\"$category\")]")
        if (response.isSuccessful && response.body() != null) {
            _tweets.emit(response.body()!!)
        }

    }

}