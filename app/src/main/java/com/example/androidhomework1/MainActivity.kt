package com.example.androidhomework1

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setUpEdgeToEdge()

        setContentView(R.layout.activity_main)

        setUpChoiceButtonsLiteners()
    }

    private fun setUpChoiceButtonsLiteners() {
        findViewById<Button>(R.id.rock_choice_button).setOnClickListener {
            choiceButtonsClickListener(Signs.Rock)
        }
        findViewById<Button>(R.id.scissors_choice_button).setOnClickListener {
            choiceButtonsClickListener(Signs.Scissors)
        }
        findViewById<Button>(R.id.paper_choice_button).setOnClickListener {
            choiceButtonsClickListener(Signs.Paper)
        }
    }

    private fun choiceButtonsClickListener(choice: Signs) {
        with(Intent(this, SecondActivity::class.java)) {
            putExtra(SecondActivity.userChoiceKeyName, choice.name)
            startActivity(this)
        }
    }

    //На этот код можете не смотреть, он нужен, но вам пока не надо знать как он работает и что делает.
    private fun setUpEdgeToEdge() {
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}