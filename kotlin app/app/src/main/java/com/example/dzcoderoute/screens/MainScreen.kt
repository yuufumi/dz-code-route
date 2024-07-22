package com.example.dzcoderoute.screens

import android.content.Context
import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.dzcoderoute.R
import com.example.dzcoderoute.componentrs.MySwiper
import com.example.dzcoderoute.componentrs.flipCard
import com.example.dzcoderoute.data.Panel
import com.example.dzcoderoute.data.readJsonFromAssets
import com.example.dzcoderoute.data.readJsonListFromAssets
import com.example.dzcoderoute.outfitFamily
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.io.File



@Composable
fun MainScreen() {
    val context = LocalContext.current
    // Usage
    val panels = readJsonListFromAssets<Panel>(context = context,fileName = "panels.json")
    Log.d("panels", panels.toString())
    Column(
        horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier
            .fillMaxSize()
            .padding(start = 24.dp, end = 24.dp, top = 28.dp)
    ) {
        Spacer(modifier = Modifier.height(30.dp))
        Text(text = "panneaux routière", style = TextStyle(fontFamily = outfitFamily, fontWeight = FontWeight.Medium, fontSize = 32.sp, color = Color(0xfffffffe)))
        Spacer(modifier = Modifier.height(20.dp))
        MySwiper(panels = panels!!)
        /*LazyRow(horizontalArrangement = Arrangement.spacedBy(26.dp)) {
            items(panels!!.size) { index ->
                flipCard(path = panels[index].image,text = panels[index].title)
            }
        }*/


    }
}


fun getImageNamesFromAssets(context: Context): List<String> {
    return try {
        context.assets.list("images")?.toList() ?: emptyList()
    } catch (e: Exception) {
        e.printStackTrace()
        emptyList()
    }
}