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
import androidx.compose.foundation.layout.Arrangement.aligned
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Colors
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.mycomposeapp.mainActivityDesign.MainActivityCompose
import com.example.mycomposeapp.ui.theme.MyComposeAppTheme

class MainActivity : ComponentActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            //color = Color.Red
            MyComposeAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),

                ) {
                    Greeting("Android")
                    /*MainActivityCompose.*/
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    /*TODO AppBar*/
    Column {
        Row(
            modifier = Modifier
                .padding(horizontal = 10.dp, vertical = 5.dp)
                .clickable {
                    Log.d("MainActivity", "Item Clicked")
                }
                .wrapContentWidth()
                .wrapContentSize(align = Alignment.Center)

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

        Column(modifier=Modifier.wrapContentWidth(Alignment.Start)) {
            Circle(shape = CircleShape)
        }
    }


}

@Composable
fun Circle(shape: Shape) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentSize(Alignment.Center)
    ) {
        Box(
            modifier = Modifier
                .size(100.dp)
                .clip(shape)
                .background(Color.Red)
        )
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