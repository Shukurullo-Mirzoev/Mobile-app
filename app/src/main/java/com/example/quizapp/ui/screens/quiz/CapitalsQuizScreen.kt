package com.example.quizapp.ui.screens.quiz

import androidx.compose.runtime.Composable
import androidx.compose.material3.MaterialTheme
import com.example.quizapp.data.getCapitalQuestions

@Composable
fun CapitalsQuizScreen(region: String, onBack: () -> Unit, onQuizFinished: () -> Unit) {
    val questions = getCapitalQuestions(region)

    QuizScreen(
        questions = questions,
        title = "Столицы",
        defaultColor = MaterialTheme.colorScheme.primary, // ✅ `buttonColor` berildi
        onBack = onBack,
        onQuizFinished = onQuizFinished // ✅ `onQuizFinished` ham berildi
    )
}


