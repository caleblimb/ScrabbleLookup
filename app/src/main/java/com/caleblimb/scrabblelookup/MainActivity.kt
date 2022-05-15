package com.caleblimb.scrabblelookup

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        // Initialize the application
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Get the components from the xml to be used in code here
        val userInput = findViewById<EditText>(R.id.editTextInput)
        val lookupResultMessage = findViewById<TextView>(R.id.textViewResult)
        val dictionary = Dictionary(this)

        // Execute as the user enters text so that they don't need to press a button for results.
        userInput.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
            }
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                // User's Input Word
                val word = userInput.text.toString()

                // Display the appropriate message depending on if the input is a real word or not.
                if (dictionary.isWord(word)) {
                    lookupResultMessage.text = word.plus(" is a word :)")
                }
                else {
                    lookupResultMessage.text = userInput.text.toString().plus(" is not a word :(")
                }
            }
        })
    }
}