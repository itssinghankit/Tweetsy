package com.example.tweetsy.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.tweetsy.viewmodels.TweetsViewModels


@Composable
fun TweetScreen() {

    val tweetViewModel:TweetsViewModels= viewModel()
    val tweets=tweetViewModel.tweets.collectAsState()

    LazyColumn(){
        items(tweets.value){
            TweetListItem(tweet = it.text)
        }
    }
}

@Composable
fun TweetListItem(tweet:String) {

    Card(
        colors = CardDefaults.cardColors(Color.White),
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        border = BorderStroke(1.dp, Color(0xFFCCCCCC))
    ) {
        Text(
            text = tweet,
            color = Color.Black,
            modifier = Modifier
                .padding(16.dp),
            style = MaterialTheme.typography.bodySmall
        )
    }
}