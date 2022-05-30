package com.example.mycomposeapp


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
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
//                HelloWorld()
            }
        }
    }
}

@Composable
fun HelloWorld() {
   /* Column(
        modifier = Modifier
            .padding(10.dp)
            .fillMaxSize()
            .background(green1)

    ) {
        Text(text = "Hello Text on Screen")
        Text(text = "Hello Text on Screen")
        Text(text = "Hello Text on Screen")
        Text(text = "Hello Text on Screen")
    }
*/

    /*LazyRow(contentPadding = PaddingValues(10.dp)){
        items(5) {
                Text(text = "Hello World")
        }
    }*/

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
        composable("AddListActivity") {
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
        /*Surface(
            modifier = Modifier
                .fillMaxSize()
        ) {
            HelloWorld()
        }*/
    }
}



