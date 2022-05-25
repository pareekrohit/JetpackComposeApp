# JetpackComposeApp

##
AppBar, MVVM, Coroutine, Retrofit, Jetpack Design. 

*For Getting viewModel() instance in composable function in jetpack compose UI use this library,* 
*use can now initiate the viewModel in composable function without depending on activity/fragment*
implementation 'androidx.lifecycle:lifecycle-viewmodel-compose:2.5.0-rc01'


*Remember the state of List (Useful for recomposition)*
*that means its same like notifyDataSetChanged() when we add any item to list jetpack should recompose or rebuild he UI for that remember and* 
*mutableState is used.*
val rememberMeals: MutableState<List<Category>> = remember{ mutableStateOf(emptyList<Category>()) }

