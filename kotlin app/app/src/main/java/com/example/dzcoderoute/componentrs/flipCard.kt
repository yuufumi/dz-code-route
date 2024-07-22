package com.example.dzcoderoute.componentrs

import android.util.Log
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.dzcoderoute.R
import com.example.dzcoderoute.outfitFamily
import java.io.File

@Composable
fun flipCard(path: String,text: String,isFlipped: Boolean, onFlip: () -> Unit){
    Log.d("isFlipped",isFlipped.toString())
    val rotation by animateFloatAsState(
        targetValue = if (isFlipped) 180f else 0f,
        label = "card_flip"
    )

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Card(
            modifier = Modifier
                .height(400.dp)
                .width(300.dp)
                .padding(24.dp)
                .graphicsLayer {
                    rotationY = rotation
                    cameraDistance = 12f * density
                }
                .clickable { onFlip() }
                ,
            colors =  CardDefaults.cardColors(containerColor = Color(0xffffffff))

        ) {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                // Front of the card
                Box(
                    modifier = Modifier
                        .graphicsLayer {
                            alpha = if (rotation < 90f) 1f else 0f
                        }
                        .fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    AssetImage(imageName = path)
                }

                // Back of the card
                Box(
                    modifier = Modifier.graphicsLayer {
                        alpha = if (rotation >= 90f) 1f else 0f
                        rotationY = 180f
                    },
                    contentAlignment = Alignment.Center
                ) {
                    Text(text = text, style = TextStyle(fontFamily = outfitFamily, textAlign = TextAlign.Center, fontWeight = FontWeight.Medium, fontSize = 24.sp, color = Color(0xff2c2c2c)))
                }
            }
        }
    }
}