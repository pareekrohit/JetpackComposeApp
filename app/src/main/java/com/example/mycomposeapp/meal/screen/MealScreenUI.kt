package com.example.mycomposeapp.meal.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import com.example.mycomposeapp.R
import com.example.mycomposeapp.meal.viewModel.MealViewModel
import com.example.mycomposeapp.model.Category
import com.example.mycomposeapp.ui.theme.MyComposeAppTheme
import com.example.mycomposeapp.ui.theme.lightBlue
import com.example.mycomposeapp.ui.theme.lightGreen

@Composable
fun MealScreen(navController: NavHostController?) {
    /**navController is passed so that u can navigate from Meal screen to any other screen*/
    Surface(
        modifier = Modifier.fillMaxSize()
    ) {
        Scaffold(
            topBar = { AppBar() },
        ) {

            Column(
                modifier = Modifier.fillMaxSize()
            ) {
                CourseMainPage(navController)
            }
        }
    }

}

@Composable
fun AppBar() {
    TopAppBar(
        title = { Text(text = "Course App", textAlign = TextAlign.Center) },
        navigationIcon = {
            IconButton(onClick = { }) {
                Icon(
                    imageVector = Icons.Filled.Menu,
                    contentDescription = "Menu Btn"
                )
            }
        },
        backgroundColor = lightBlue,
        contentColor = Color.White,
        elevation = 2.dp,
    )
}


@Composable
fun CourseMainPage(navController: NavHostController?) {
    Column(modifier = Modifier.padding(15.dp)) {

        Button(onClick = { navController?.navigate("chatScreen") }) {
            Text(text = "Go to Chat Screen")
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
        ) {
            Column(
                horizontalAlignment = Alignment.Start, modifier = Modifier.weight(0.7f)
            ) {
                Text(text = "Good morning, Greeks", fontSize = 26.sp)
                Text(text = "We wish you have a good day!")
            }

            Image(
                painter = painterResource(id = R.drawable.ic_search),
                contentDescription = "",
                modifier = Modifier
                    .size(0.dp, 40.dp)
                    .align(alignment = Alignment.CenterVertically)
                    .weight(0.3f),
            )
        }

        Spacer(modifier = Modifier.height(30.dp))
        LazyList()
    }

}


@Composable
fun LazyList() {
    val viewModel: MealViewModel = viewModel()
    /*val rememberMeals: MutableState<List<Category>> = remember{ mutableStateOf(emptyList<Category>()) }*/

    LazyRow() {
        items(viewModel.mealState.value) { model ->
            MySubjectList(item = model) {}
        }
    }
    DailyCodeCard()
}

@Composable
fun MySubjectList(item: Category, onCardClick: () -> Unit) {
    Card(
        modifier = Modifier
            .wrapContentHeight()
            .wrapContentWidth()
            .padding(10.dp),
        shape = RoundedCornerShape(10.dp),
        elevation = 10.dp,
    ) {

        Column(
            modifier = Modifier
                .background(lightGreen)
                .wrapContentHeight()
                .wrapContentWidth()
                .clickable { onCardClick }
        ) {
            val painter = rememberAsyncImagePainter(
                model = ImageRequest.Builder(LocalContext.current)
                    .data(item.strCategoryThumb)
                    .build()
            )

            Image(
                painter = painter,
                contentDescription = "",
                modifier = Modifier
                    .size(60.dp)
                    .align(Alignment.CenterHorizontally),
            )

            Text(
                text = item.strCategory,
                modifier = Modifier
                    .padding(20.dp, 0.dp, 20.dp, 7.dp)
                    .wrapContentHeight()
                    .wrapContentWidth(), // make text center vertical
                textAlign = TextAlign.Center // make text center horizontal , fontSize = 20.sp
            )

        }
    }
}

@Composable
fun DailyCodeCard() {
    Card(
        modifier = Modifier
            .wrapContentHeight()
            .fillMaxWidth()
            .padding(10.dp, 25.dp, 10.dp, 10.dp),
        shape = RoundedCornerShape(10.dp),
        elevation = 10.dp,
    ) {

        Column(
            Modifier
                .fillMaxWidth()
                .wrapContentHeight()
                .background(lightGreen)
                .padding(10.dp),
            horizontalAlignment = Alignment.CenterHorizontally,

            ) {

            Row(
                Modifier.fillMaxWidth()
            ) {

                Column(
                    Modifier.weight(0.8f),
                    verticalArrangement = Arrangement.Center
                ) {
                    Text(
                        text = "Daily Coding",
                        Modifier.fillMaxWidth(),
                        fontSize = 26.sp,
                    )
                    Text(
                        text = "do at least 3-10 problems/day",
                        Modifier.fillMaxWidth()
                    )
                }

                Image(
                    painter = painterResource(id = R.drawable.ic_play),
                    contentDescription = "",
                    modifier = Modifier
                        .size(60.dp, 100.dp)
                        .padding(10.dp)
                        .weight(0.5f),
                    contentScale = ContentScale.Fit,
                    alignment = Alignment.CenterEnd
                )
            }

        }

    }

    SetCourses();
}

@Composable
fun SetCourses() {
    Spacer(modifier = Modifier.height(10.dp))

    Text(
        text = "courses",
        modifier = Modifier.padding(10.dp, 0.dp, 0.dp, 0.dp),
        fontSize = 20.sp
    )

    /*Spacer(modifier = Modifier.height(10.dp))*/

    val courseList = ArrayList<String>()
    courseList.add("Advance Python Course")
    courseList.add("Advance Java Course")
    courseList.add("Prepare for Aptitude")
    courseList.add("Hoe Does AI")

    LazyColumn {
        items(courseList) { model ->
            Row(Modifier.padding(10.dp)) {
                Card(
                    modifier = Modifier
                        .padding(0.dp, 10.dp)
                        .height(80.dp)
                        .weight(1f),
                    backgroundColor = lightBlue,
                    shape = RoundedCornerShape(10.dp),
                ) {
                    Column(modifier = Modifier.padding(10.dp)) {

                        Text(
                            text = model, fontSize = 16.sp,
                            modifier = Modifier.padding(0.dp, 0.dp, 20.dp, 0.dp)
                        )
                    }
                }


                Card(
                    modifier = Modifier
                        .padding(10.dp)
                        .height(80.dp)
                        .weight(1f),
                    backgroundColor = lightBlue,
                    shape = RoundedCornerShape(10.dp)
                ) {
                    Column(modifier = Modifier.padding(10.dp)) {

                        Text(
                            text = model, fontSize = 16.sp
                        )
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun Preview1() {
    MyComposeAppTheme() {
        MealScreen(null)
    }
}