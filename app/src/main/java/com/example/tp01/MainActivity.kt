package com.example.tp01

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.windowsizeclass.ExperimentalMaterial3WindowSizeClassApi
import androidx.compose.material3.windowsizeclass.WindowSizeClass
import androidx.compose.material3.windowsizeclass.calculateWindowSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
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
                    print("ok")
                    val windowClass = calculateWindowSizeClass(activity = this)
                    Screen(windowClass)



                }

                }

            }
@Composable
fun Screen(windowClass : WindowSizeClass) {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = "Profil") {
        composable("Profil"){
        Profil(windowClass, navController)
        }
        composable("film"){
            Films(windowClass, navController, MainViewModel())
        }
};
}

