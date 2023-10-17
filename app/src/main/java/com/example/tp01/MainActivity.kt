package com.example.tp01

import android.annotation.SuppressLint
import android.os.Bundle
import android.text.style.BackgroundColorSpan
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.padding
import androidx.compose.material.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarColors
import androidx.compose.material3.windowsizeclass.ExperimentalMaterial3WindowSizeClassApi
import androidx.compose.material3.windowsizeclass.WindowSizeClass
import androidx.compose.material3.windowsizeclass.calculateWindowSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.*
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController


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
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Screen(windowClass : WindowSizeClass) {
    Scaffold(
            topBar = {
                TopAppBar(
                    title = { Text("Les Films de Jeff", textAlign = TextAlign.Center)})},
        bottomBar = {
            BottomAppBar(){
                Text(text = "BottomAppBar")
        }},
    content={
        val navController = rememberNavController()
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
        };

})}
