package com.example.quizapp.ui.screens.quiz

import androidx.compose.runtime.*
import com.example.quizapp.data.getFlagQuestions

@Composable
fun FlagsQuizScreen(region: String, onQuizFinished: () -> Unit) {
    val questions = getFlagQuestions(region) // To'g'ri formatdagi ro'yxat qaytadi
    QuizScreen(questions, "Флаги", onQuizFinished)
}
