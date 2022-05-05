package com.caleblimb.scrabblelookup

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText
import android.widget.TextView
import com.caleblimb.scrabblelookup.Dictionary

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val userInput = findViewById<EditText>(R.id.editTextInput)

        val lookupResultMessage = findViewById<TextView>(R.id.textViewResult)

        val dictionary = Dictionary()

        userInput.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
            }
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                var word = userInput.text.toString()
                if (dictionary.isWord(word)) {
                    lookupResultMessage.text = word.plus(" is an A word :)")
                }
                else {
                    lookupResultMessage.text = userInput.text.toString().plus(" is not an A word :(")
                }
            }
        })
    }
}