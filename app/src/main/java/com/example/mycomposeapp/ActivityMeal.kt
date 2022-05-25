package com.example.mycomposeapp


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.mycomposeapp.meal.screen.MealScreen
import com.example.mycomposeapp.meal.screen.AddListScreen
import com.example.mycomposeapp.meal.screen.ChatScreen
import com.example.mycomposeapp.ui.theme.*


class ActivityMeal : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()

            MyComposeAppTheme {
                NavigationScreen(navController)
            }
        }
    }
}

@Composable
fun NavigationScreen(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = "home"
    ) {
        composable("home") {
            MealScreen(navController)
        }
        composable("chatScreen") {
            ChatScreen(navController)
        }
        composable("AddListActivity"){
            AddListScreen()
        }
    }

}


/*@Composable
fun HelloText(text: String) {
    val courseList = ArrayList<String>()
    courseList.add("Advance Python Course")
    courseList.add("Advance Java Course")
    courseList.add("Prepare for Aptitude")
    courseList.add("Hoe Does AI")

    LazyColumn {
        items(courseList) { model ->
            Text(text = model)
        }
    }

}*/

@Preview(showBackground = true)
@Composable
fun Preview() {
    MyComposeAppTheme() {
        MealScreen(null)
        /*Surface(modifier = Modifier.fillMaxSize().padding(20.dp)) {
            HelloText(text = "Android")
        }*/

    }
}


/*Surface(modifier = Modifier.fillMaxSize().padding(20.dp)) {
            HelloText(text = "Android")
        }*/

