package com.example.mycomposeapp.meal.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.mycomposeapp.ui.theme.MyComposeAppTheme
import com.example.mycomposeapp.ui.theme.chatGreen
import com.example.mycomposeapp.R

@Composable
fun ChatScreen(navController: NavHostController?) {
    Column() {
        LazyColumn() {
            items(3) {
                LAftChat()
            }
        }


        /*Row(
            verticalAlignment = Alignment.Bottom,
            modifier = Modifier.height(50.dp)
        ) {
            Text(text = "Hi hello")
        }*/

    }
}

@Composable
fun LAftChat() {
    Row(modifier = Modifier.padding(10.dp, 10.dp, 10.dp, 5.dp)) {
        Image(
            painter = painterResource(id = R.drawable.pic),
            contentDescription = "",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .clip(RoundedCornerShape(30.dp))
                .border(2.dp, color = chatGreen, shape = RoundedCornerShape(30.dp))
                .size(50.dp)
        )


        Column(modifier = Modifier.padding(10.dp, 0.dp, 0.dp, 0.dp)) {
            Text(
                text = "Colleague", fontSize = 17.sp,
                modifier = Modifier.padding(0.dp, 0.dp, 0.dp, 3.dp),
                color = chatGreen,
                fontWeight = FontWeight.SemiBold
            )

            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight()
                    .padding(0.dp, 5.dp, 5.dp, 0.dp),
                elevation = 7.dp
            ) {

                Text(
                    text = "Take a look at Jetpack Compose", fontSize = 16.sp,
                    modifier = Modifier.padding(10.dp),
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MyComposeAppTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colors.background
        ) {
            ChatScreen(null)
        }
    }

}