package com.example.androidhomework1

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.androidhomework1.GameResultUtils.getGameResult

class SecondActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        setUpGameResults()

        setUpBackButtonClickListener()
    }

    private fun setUpGameResults() {

        val userChoice = Signs.valueOf(intent.getStringExtra(USER_CHOICE_KEY_NAME) ?: Signs.Rock.name)

        findViewById<TextView>(R.id.your_choice_text_view).text = userChoice.value

        val computerChoice = Signs.entries.random()

        findViewById<TextView>(R.id.computer_choice_text_view).text = computerChoice.value

        findViewById<TextView>(R.id.game_result_text_view).text = getGameResult(
            playerChoice = userChoice,
            computerChoice = computerChoice
        )
    }
    private fun setUpBackButtonClickListener() {
        findViewById<Button>(R.id.back_button).setOnClickListener {
            this.finish()
        }
    }

    companion object {
        const val USER_CHOICE_KEY_NAME = "UserChoiceKeyName"
    }
}