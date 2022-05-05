package com.caleblimb.scrabblelookup

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import java.io.IOException
import java.io.InputStream

class Dictionary(context: Context) {
    val words: List<String>
    val fileName: String = "words.txt"

    init {
        var string: String = ""
        val delimiter = "\n"
        try {
            val inputStream: InputStream = context.assets.open(fileName)
            val size: Int = inputStream.available()
            val buffer = ByteArray(size)
            inputStream.read(buffer)
            string = String(buffer)
        } catch (e: IOException) {
            e.printStackTrace()
        }
        words = string.split(delimiter)

    }

    fun isWord(word: String): Boolean {
        val index = words.binarySearch(word, CompareWords, 0, words.size)
        print(index)
        return index >= 0
    }

    fun indexOf(word: String): Int {
        return words.binarySearch(word, CompareWords, 0, words.size)
    }
}

class CompareWords {
    companion object : Comparator<String> {
        override fun compare(o1: String, o2: String): Int {
            return o1.compareTo(o2)
        }
    }
}
