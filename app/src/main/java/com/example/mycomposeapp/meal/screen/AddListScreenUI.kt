package com.example.mycomposeapp.meal.screen

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.mycomposeapp.ui.theme.MyComposeAppTheme


@Composable
fun AddListScreen() {
    Column(
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        AddList()
    }
}

@Composable
fun AddList() {
    Log.d("AddListActivity", "AddList")
    val rememberStateList = remember { mutableStateListOf<String>("Rohit", "Akash") }

    for (name in rememberStateList) {
        Greeting(name = name)
    }

    Button(
        modifier = Modifier.padding(10.dp, 20.dp),
        onClick = { rememberStateList.add("Sanjay") }) {
        Text(text = "Click Me To Add")
    }

}


@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun Preview2() {
    MyComposeAppTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colors.background
        ) {
            AddListScreen()
        }
    }
}