package com.simpleapps22.rolladice

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.simpleapps22.rolladice.databinding.ActivityMainBinding

/**
 * Roll A Dice demonstrates simple interactivity in an Android app.
 * It contains one button that updates a text view with a random
 * value between 1 and 6.
 */
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding.apply { // Assign a click listener to a button.
            rollButton.setOnClickListener { rollDice() }

            clearButton.setOnClickListener { resetImage() }
        }
    }

    /**
     * Click listener for the Roll button.
     */
    private fun rollDice() {
        binding.apply {
            diceImage.setImageResource(getRandomDiceImage())
            diceImage1.setImageResource(getRandomDiceImage())
        }
    }

    /**
     * Click listener for the Clear button.
     */
    private fun resetImage() {
        binding.apply {
            diceImage.setImageResource(R.drawable.dice_1)
            diceImage1.setImageResource(R.drawable.dice_1)}
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
