package com.example.tweetsy.api

import com.example.tweetsy.models.TweetListItem
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Headers

interface TweetsyInterfaceApi {

    @GET("/v3/b/651af3b654105e766fbcbd81?meta=false")
    suspend fun getTweets(@Header("X-JSON-Path")category:String):Response<List<TweetListItem>>

    @GET("/v3/b/651af3b654105e766fbcbd81?meta=false")
    @Headers("X-JSON-Path : tweets..catagory")
    suspend fun getCatagories():Response<List<String>>

}