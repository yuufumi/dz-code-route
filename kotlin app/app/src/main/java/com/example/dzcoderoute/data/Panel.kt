package com.example.dzcoderoute.data

import android.content.Context
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.io.File
import java.io.IOException

data class Panel(
    val image: String,
    val title: String
)





fun <T> readJsonFromAssets(context: Context, fileName: String, classOfT: Class<T>): T? {
    var jsonString: String? = null
    try {
        jsonString = context.assets.open(fileName).bufferedReader().use { it.readText() }
    } catch (ioException: IOException) {
        ioException.printStackTrace()
        return null
    }
    return Gson().fromJson(jsonString, classOfT)
}

// For reading a list of objects
inline fun <reified T> readJsonListFromAssets(context: Context, fileName: String): List<T>? {
    var jsonString: String? = null
    try {
        jsonString = context.assets.open(fileName).bufferedReader().use { it.readText() }
    } catch (ioException: IOException) {
        ioException.printStackTrace()
        return null
    }
    val type = object : TypeToken<List<T>>() {}.type
    return Gson().fromJson(jsonString, type)
}
