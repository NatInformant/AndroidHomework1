package com.example.androidhomework1

object GameResultUtils {
    const val winText = "Вы победили!"
    const val loseText = "Вы проиграли!"
    const val drawText = "Ничья!"

    fun getGameResult(playerChoice: Signs, computerChoice:Signs)=
        when {
            playerChoice == Signs.Rock && computerChoice == Signs.Scissors -> winText
            playerChoice == Signs.Rock && computerChoice == Signs.Rock -> drawText
            playerChoice == Signs.Rock && computerChoice == Signs.Paper -> loseText
            playerChoice == Signs.Paper && computerChoice == Signs.Scissors -> loseText
            playerChoice == Signs.Paper && computerChoice == Signs.Rock -> winText
            playerChoice == Signs.Paper && computerChoice == Signs.Paper -> drawText
            playerChoice == Signs.Scissors && computerChoice == Signs.Scissors -> drawText
            playerChoice == Signs.Scissors && computerChoice == Signs.Rock -> loseText
            else -> winText
        }

}