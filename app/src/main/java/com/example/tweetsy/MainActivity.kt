package com.example.tweetsy

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.tweetsy.api.TweetsyInterfaceApi
import com.example.tweetsy.screens.CategoryScreen
import com.example.tweetsy.screens.TweetScreen
import com.example.tweetsy.ui.theme.TweetsyTheme
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

//    @Inject
//    lateinit var tweetsyInstanceAPI : TweetsyInterfaceApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

//        GlobalScope.launch {
//           val response=tweetsyInstanceAPI.getCategories()
//            Log.d("Ankit",response.body()!!.distinct().toString())
//        }

        setContent {
            TweetsyTheme {
                TweetScreen()
//               CategoryScreen()
            }
        }
    }
}
