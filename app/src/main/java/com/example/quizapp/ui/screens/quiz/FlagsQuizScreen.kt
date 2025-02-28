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
        buttonColor = MaterialTheme.colorScheme.primary, // ✅ `buttonColor` berildi
        onBack = onBack,
        onQuizFinished = onQuizFinished // ✅ `onQuizFinished` ham berildi
    )
}

//package com.example.quizapp.ui.screens.quiz
//
//import androidx.compose.runtime.Composable
//import androidx.compose.material3.MaterialTheme
//import com.example.quizapp.data.getFlagQuestions
//
//@Composable
//fun FlagsQuizScreen(region: String, onBack: () -> Unit, onQuizFinished: () -> Unit) {
//    val questions = getFlagQuestions(region)
//
//    QuizScreen(
//        questions = questions,
//        title = "Флаги",
//        buttonColor = MaterialTheme.colorScheme.primary, // ✅ `buttonColor` berildi
//        onBack = onBack,
//        onQuizFinished = onQuizFinished // ✅ `onQuizFinished` ham berildi
//    )
//}
//
//package com.example.quizapp.ui.screens.quiz
//
//import androidx.compose.runtime.Composable
//import com.example.quizapp.data.getFlagQuestions
//
//
//@Composable
//fun FlagsQuizScreen(region: String, onQuizFinished: () -> Unit) {
//    val questions = getFlagQuestions(region)
//    QuizScreen("Флаги", questions[0].first.toString(), questions[0].second, onAnswerSelected = { onQuizFinished() })
//}