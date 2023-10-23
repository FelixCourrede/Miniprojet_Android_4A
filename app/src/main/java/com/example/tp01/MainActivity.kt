package com.example.tp01

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.compose.material.MaterialTheme
import android.text.style.BackgroundColorSpan
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.BottomNavigation
import androidx.compose.material.MaterialTheme.colors
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.Scaffold
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.*
import androidx.compose.material3.TopAppBarColors
import androidx.compose.material3.windowsizeclass.ExperimentalMaterial3WindowSizeClassApi
import androidx.compose.material3.windowsizeclass.WindowSizeClass
import androidx.compose.material3.windowsizeclass.calculateWindowSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.*
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.tp01.ui.theme.Purple40


class MainActivity : ComponentActivity() {
            @OptIn(ExperimentalMaterial3WindowSizeClassApi::class)
            override fun onCreate(savedInstanceState: Bundle?) {
                super.onCreate(savedInstanceState)
                setContent {
                    val windowClass = calculateWindowSizeClass(activity = this)
                    Screen(windowClass)



                }

                }

            }
@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun Screen(windowClass : WindowSizeClass) {
    val navController = rememberNavController()
    Scaffold(
            topBar = {
                CenterAlignedTopAppBar(
                title ={Text("Les films de Jeff")},

                    colors= TopAppBarDefaults.mediumTopAppBarColors(
                    containerColor = Purple40,
                    titleContentColor = Color.White,
                ),
                modifier=Modifier.height(50.dp)
            )
            },


    bottomBar = {
        BottomNavBar(navController)
    },


    content={it

        NavHost(
            navController = navController,
            startDestination = "Profil"
        ) {
            composable("Profil") {
                Profil(windowClass, navController)
            }
            composable("film") {
                Films(windowClass, navController, MainViewModel())

            }
            composable("Series") {
                SeriesFun(windowClass, navController, MainViewModel())
            }
        }
        })
}

@Composable
fun BottomNavBar(navController: NavController){
    BottomAppBar(
        modifier=Modifier.height(60.dp),
        containerColor = Purple40,
        actions = {
            Row(modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly){
                IconButton(onClick = { navController.navigate("film") }, Modifier.size(50.dp)) {
                    Column(verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally){
                        Icon(
                            painter = painterResource(id = R.drawable._3598),
                            contentDescription = "Localized description",
                            tint = Color.White
                        )
                        Text(text = "Films", color = Color.White, fontSize = 10.sp)
                    }
        }
                IconButton(onClick = { navController.navigate("Series") }, Modifier.size(95.dp)) {
                    Column(verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally,) {
                        Icon(
                            painter = painterResource(
                                id = R.drawable.pngwing
                            ),
                            contentDescription = "Localized description",
                            tint = Color.White,
                        )
                        Text(text = "Séries", color = Color.White, fontSize = 10.sp)
                    }}}})}
