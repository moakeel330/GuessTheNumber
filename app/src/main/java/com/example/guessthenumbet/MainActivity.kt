package com.example.guessthenumbet

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    private var randomNumber : Int = 0
    private var guessNumber : TextView? = null
    private var responseText : TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        generateRandomNumber()

        guessNumber = findViewById(R.id.numInput)
        responseText = findViewById(R.id.resultText)

        val guessBtn = findViewById<Button>(R.id.guessBtn)

        guessBtn.setOnClickListener(){
            compare()
        }
    }

    private fun generateRandomNumber(){
        randomNumber = Random.nextInt(1, 100)
    }

    private fun compare(){
        val guessNumber = guessNumber?.text.toString().trim().toInt()

        if (guessNumber == randomNumber){
            responseText?.text = "Great, ${guessNumber.toString()} is the correct guess!"
        }

        else if (guessNumber > randomNumber){
            responseText?.text = "Sorry, ${guessNumber.toString()} is too high"
        }
        else {
            responseText?.text = "Sorry, ${guessNumber.toString()} is too low"
        }
    }
}