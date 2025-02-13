package com.example.quizapp.ui.screens.quiz

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.quizapp.data.getMoneyQuestions
@Composable
fun MoneyQuizScreen(region: String, onQuizEnd: () -> Unit) {
    val questions = remember { getMoneyQuestions(region) }
    var questionIndex by remember { mutableStateOf(0) }
    var score by remember { mutableStateOf(0) }
    var selectedAnswer by remember { mutableStateOf<String?>(null) }

    if (questionIndex >= questions.size) {
        ResultScreen(score, questions.size, onQuizEnd)
    } else {
        val (currency, options) = questions[questionIndex]

        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Валюта: $currency",
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(16.dp)
            )

            options.shuffled().chunked(2).forEach { row ->
                Row {
                    row.forEach { option ->
                        Button(
                            onClick = {
                                selectedAnswer = option
                                if (option == options[0]) {
                                    score++
                                }
                                questionIndex++
                            },
                            modifier = Modifier
                                .weight(1f)
                                .padding(8.dp)
                        ) {
                            Text(option)
                        }
                    }
                }
            }
        }
    }
}
