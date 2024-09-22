package com.example.androidhomework1

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.androidhomework1.GameResultUtils.getGameResult

class SecondActivity : AppCompatActivity() {

    private val computerChoiceRange = 1..3
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        setUpGameResults()

        findViewById<Button>(R.id.back_button).setOnClickListener{
            this.finish()
        }
    }

    private fun setUpGameResults() {

        val userChoice = Signs.valueOf(intent.getStringExtra(userChoiceKeyName) ?: Signs.Rock.name)

        findViewById<TextView>(R.id.your_choice_text_view).text = userChoice.value

        val computerChoice = when (computerChoiceRange.random()) {
            1 -> Signs.Rock
            2 -> Signs.Scissors
            else -> Signs.Paper
        }

        findViewById<TextView>(R.id.computer_choice_text_view).text = computerChoice.value

        findViewById<TextView>(R.id.game_result_text_view).text = getGameResult(
            playerChoice = userChoice,
            computerChoice = computerChoice
        )
    }

    companion object {
        const val userChoiceKeyName = "UserChoiceKeyName"
    }
}