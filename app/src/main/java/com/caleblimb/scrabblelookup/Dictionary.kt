package com.caleblimb.scrabblelookup

import android.content.Context
import java.io.IOException
import java.io.InputStream

class Dictionary(context: Context) {
    val fileName: String = "words.txt"
    val words: Set<String>

    init {
        var string: String = ""
        val delimiter = "\r\n"
        try {
            val inputStream: InputStream = context.assets.open(fileName)
            val size: Int = inputStream.available()
            val buffer = ByteArray(size)
            inputStream.read(buffer)
            string = String(buffer)
        } catch (e: IOException) {
            e.printStackTrace()
        }
        words = string.lowercase().split(delimiter).toSet()
    }

    fun isWord(word: String): Boolean {
        return (word.lowercase().filter{!it.isWhitespace()} in words)
    }
}
