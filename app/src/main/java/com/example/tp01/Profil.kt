package com.example.tp01

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.windowsizeclass.WindowSizeClass
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.tp01.ui.theme.Tp01Theme


@Composable
fun Screen (windowClass: WindowSizeClass) {
    when (windowClass.widthSizeClass) {
        WindowWidthSizeClass.Compact -> {
            Tp01Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Box(contentAlignment = Alignment.TopCenter) {
                        imageTuche()
                        liensRéseaux()
                    }
                }
            }
        }

        else -> {
            Tp01Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {


                }
            }
        }
    }
}

    @Composable
    fun imageTuche() {
        Column(horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.padding(horizontal = 0.dp, vertical = 156.dp)) {
            Image(
                painterResource(id = R.drawable.tuche),
                contentDescription = "Jeff",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(200.dp)
                    .clip(CircleShape)
            )
            Text(text = "Jeff Tuche")
            Text(text = "Président de la république")
        }
    }


    @Composable
    fun liensRéseaux(){
        Column(Modifier.padding(top = 450.dp)) {
            Text(text = "Facebook")
            Text(text = "LinkedIn")
        }
    }

    @Composable
    fun bouton(){
        Column() {
            Button(onClick = { /*TODO*/ }) {

            }
        }
    }