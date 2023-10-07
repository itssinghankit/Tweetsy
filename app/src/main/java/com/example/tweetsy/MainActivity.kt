package com.example.tweetsy

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.tweetsy.screens.CategoryScreen
import com.example.tweetsy.screens.TweetScreen
import com.example.tweetsy.ui.theme.TweetsyTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    //    @Inject
//    lateinit var tweetsyInstanceAPI : TweetsyInterfaceApi
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

//        GlobalScope.launch {
//           val response=tweetsyInstanceAPI.getCategories()
//            Log.d("Ankit",response.body()!!.distinct().toString())
//        }

        setContent {
            TweetsyTheme {
                Scaffold(modifier = Modifier.fillMaxWidth(), topBar = {
                    TopAppBar(
                        title = { Text(text = "Tweetsy") },
                        colors = TopAppBarDefaults.smallTopAppBarColors(
                            containerColor = Color.Black,
                            titleContentColor = Color.White
                        )
                    )
                }) {
                    Box(modifier = Modifier.padding(it)) {
                        App()
                    }
                }
//                App()
//                TweetScreen()
//               CategoryScreen()
            }
        }
    }

}

@Composable
fun App() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "category") {
        composable(route = "category") {
            CategoryScreen {
                navController.navigate("detail/${it}")
            }
        }
        //passing the category to check the category of tweets we want
        composable(route = "detail/{category}", arguments = listOf(
            navArgument("category") {
                type = NavType.StringType
            }
        )) {
            TweetScreen()
        }
    }
}