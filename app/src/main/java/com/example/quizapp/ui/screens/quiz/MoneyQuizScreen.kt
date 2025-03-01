package com.example.quizapp.ui.screens.quiz

import androidx.compose.runtime.Composable
import androidx.compose.material3.MaterialTheme
import com.example.quizapp.data.getMoneyQuestions


@Composable
fun MoneyQuizScreen(region: String, onBack: () -> Unit, onQuizFinished: () -> Unit) {
    val questions = getMoneyQuestions(region)

    QuizScreen(
        questions = questions,
        title = "Деньги",
        defaultColor = MaterialTheme.colorScheme.primary, // ✅ `buttonColor` berildi
        onBack = onBack,
        onQuizFinished = onQuizFinished // ✅ `onQuizFinished` ham berildi
    )
}
