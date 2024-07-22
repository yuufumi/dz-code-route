package com.example.dzcoderoute.componentrs

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.wear.compose.material.Button
import androidx.wear.compose.material.Text
import com.example.dzcoderoute.data.Panel
import com.example.dzcoderoute.outfitFamily

@Composable
fun MySwiper(panels: List<Panel>) {
    var currentIndex by remember { mutableStateOf(0) }
    var isFlipped by remember { mutableStateOf(false) }
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text(
            text = "${currentIndex+1}/119",
            style = TextStyle(
                fontFamily = outfitFamily,
                fontWeight = FontWeight.Bold,
                fontSize = 32.sp,
                color = Color(0xfffffffe)
            )
        )
        Spacer(modifier = Modifier.height(20.dp))
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center,
        ) {
            Button(onClick = {
                if (currentIndex > 0) {
                    isFlipped = false
                    currentIndex--
                }
            }) {
                Text("<",
                    style = TextStyle(
                        fontFamily = outfitFamily,
                        fontWeight = FontWeight.Bold,
                        fontSize = 32.sp,
                        color = Color(0xff2c2c2c)
                    )
                )
            }
            Spacer(modifier = Modifier.width(100.dp))
            Button(onClick = {
                if (currentIndex < panels.size - 1) {
                    currentIndex++
                    isFlipped = false
                }

            }) {
                Text(">",
                    style = TextStyle(
                        fontFamily = outfitFamily,
                        fontWeight = FontWeight.Bold,
                        fontSize = 32.sp,
                        color = Color(0xff2c2c2c)
                    )
                )
            }
        }
        flipCard(path = panels[currentIndex].image,text = panels[currentIndex].title,isFlipped=isFlipped){isFlipped = !isFlipped}
        Log.d("flipped",isFlipped.toString())

    }
}