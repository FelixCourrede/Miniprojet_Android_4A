package com.example.tp01

import android.util.DisplayMetrics
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.windowsizeclass.ExperimentalMaterial3WindowSizeClassApi
import androidx.compose.material3.windowsizeclass.WindowSizeClass
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.material3.windowsizeclass.calculateWindowSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.tp01.ui.theme.Tp01Theme



@OptIn(ExperimentalMaterial3WindowSizeClassApi::class)
@Composable
fun Profil (windowClass: WindowSizeClass) {
    when (windowClass.widthSizeClass) {
        WindowWidthSizeClass.Compact -> {
            Tp01Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Box(contentAlignment = Alignment.TopCenter) {
                        imageTuche(0)
                        liensRéseaux(0)
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
                    Row (Modifier.padding(horizontal = 100.dp)){
                        imageTuche(1)
                        liensRéseaux(1)
                    }

                }
            }
        }
    }
}

    @Composable
    fun imageTuche(i: Int) {
        var h=0;
        var v =50
        var c= CircleShape

        if (i==1){
            //Ecran allongé
            h=30
            v=20
            c= RoundedCornerShape(30.dp)
        }
        Column(horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.padding(horizontal = h.dp, vertical = v.dp)) {
            Image(
                painterResource(id = R.drawable.tuche),
                contentDescription = "Jeff",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(250.dp)
                    .clip(c)
            )
            Text(text = "Jeff Tuche")
            Text(text = "Président de la république")
        }
    }


    @Composable
    fun liensRéseaux(i: Int){
        var p=400
        if (i==1) {
            p = 125;
        }
        Column(Modifier.padding(top = p.dp)) {
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