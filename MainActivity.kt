package com.simpleapps22.rolladice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView

/**
 * Roll A Dice demonstrates simple interactivity in an Android app.
 * It contains one button that updates a text view with a random
 * value between 1 and 6.
 */
class MainActivity : AppCompatActivity() {

    lateinit var diceImage: ImageView
    lateinit var diceImage1: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        diceImage = findViewById(R.id.dice_image)
        diceImage1 = findViewById(R.id.dice_image1)

        // Get the Button view from the layout and assign a click
        // listener to it.
        val rollButton: Button = findViewById(R.id.roll_button)
        rollButton.setOnClickListener { rollDice() }

        val clearButton: Button = findViewById(R.id.clear_button)
        clearButton.setOnClickListener { resetImage() }
    }

    /**
     * Click listener for the Roll button.
     */
    private fun rollDice() {
        diceImage.setImageResource(getRandomDiceImage())
        diceImage1.setImageResource(getRandomDiceImage())
    }

    /**
     * Click listener for the Clear button.
     */
    private fun resetImage() {
        diceImage.setImageResource(R.drawable.dice_1)
        diceImage1.setImageResource(R.drawable.dice_1)
    }

    private fun getRandomDiceImage(): Int {
        val randomInt = (1..6).random()

        return when (randomInt) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }
    }
}
