package com.example.quizapp.ui.screens.quiz

import androidx.compose.runtime.Composable
import androidx.compose.material3.MaterialTheme
import com.example.quizapp.data.getFlagQuestions


@Composable
fun FlagsQuizScreen(region: String, onBack: () -> Unit, onQuizFinished: () -> Unit) {
    val questions = getFlagQuestions(region)

    QuizScreen(
        questions = questions,
        title = "Флаги",
        defaultColor = MaterialTheme.colorScheme.primary, // ✅ `buttonColor` berildi
        onBack = onBack,
        onQuizFinished = onQuizFinished // ✅ `onQuizFinished` ham berildi
    )
}

