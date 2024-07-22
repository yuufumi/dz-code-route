package com.example.dzcoderoute.componentrs

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest

@Composable
fun AssetImage(imageName: String) {
    val context = LocalContext.current
    Image(
        painter = rememberAsyncImagePainter(
            ImageRequest.Builder(context)
                .data("file:///android_asset/$imageName")
                .build()
        ),
        contentDescription = "Image from assets",
        modifier = Modifier.size(160.dp)
    )
}