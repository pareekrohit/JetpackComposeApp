package com.example.mycomposeapp

import android.graphics.Paint
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.Arrangement.Top
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.mycomposeapp.ui.theme.MyComposeAppTheme

class MainActivity : ComponentActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyComposeAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Greeting("Android")
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {

    /*TODO AppBar*/

    Row(
        modifier = Modifier
            .padding(horizontal = 10.dp, vertical = 5.dp)
            .clickable {
                Log.d("MainActivity", "Item Clicked")
            }
            .wrapContentHeight(align = Alignment.Top)
    ) {

        Image(
            painter = painterResource(R.drawable.ic_launcher_background),
            contentDescription = "image",
        )

        Column(modifier = Modifier.padding(10.dp)) {
            Text(text = "Rohit")
            Text(text = "Pareekh")
            Text(text = "Hello $name!")
        }
    }


    
}

@Composable
fun ShowMessage(msg: String) {
    Toast.makeText(LocalContext.current, msg, Toast.LENGTH_LONG).show()
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MyComposeAppTheme {
        Greeting("Android")
    }
}