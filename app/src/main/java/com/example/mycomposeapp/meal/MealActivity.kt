package com.example.mycomposeapp.meal

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.mycomposeapp.meal.ui.theme.MyComposeAppTheme

class MealActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            MyComposeAppTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    MealsCategoriesScreen()
                }
            }
        }
    }
}

@Composable
fun MealsCategoriesScreen() {

}

@Preview(showBackground = true)
@Composable
fun DefaultPreview4() {
    MyComposeAppTheme {
        MealsCategoriesScreen()
    }
}