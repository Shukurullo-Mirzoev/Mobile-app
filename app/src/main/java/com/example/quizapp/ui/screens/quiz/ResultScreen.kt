package com.example.quizapp.ui.screens.quiz

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp


@Composable
fun ResultScreen(correct: Int, wrong: Int, onRetry: () -> Unit) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = "Тест завершен!", fontSize = 28.sp)
        Text(text = "Правильные ответы: $correct", fontSize = 22.sp)
        Text(text = "Неправильные ответы: $wrong", fontSize = 22.sp)
        Button(onClick = onRetry) {
            Text(text = "Попробовать снова")
        }
    }
}
