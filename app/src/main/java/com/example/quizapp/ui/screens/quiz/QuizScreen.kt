package com.example.quizapp.ui.screens.quiz

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@OptIn(ExperimentalMaterial3Api::class)

@Composable
fun QuizScreen(questions: List<Pair<String, List<String>>>, title: String, onQuizFinished: () -> Unit) {
    var currentIndex by remember { mutableIntStateOf(0) }
    var correctAnswers by remember { mutableIntStateOf(0) }
    var wrongAnswers by remember { mutableIntStateOf(0) }

    if (currentIndex >= questions.size) {
        ResultScreen(correctAnswers, wrongAnswers, onQuizFinished)
        return
    }

    val (question, options) = questions[currentIndex]

    Scaffold(
        topBar = { TopAppBar(title = { Text(title) }) }
    ) { paddingValues ->
        Column(
            modifier = Modifier.fillMaxSize().padding(paddingValues).padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top
        ) {
            Text(text = "${currentIndex + 1}/${questions.size}", fontSize = 20.sp)
            Spacer(modifier = Modifier.height(16.dp))
            Text(text = question, fontSize = 24.sp)
            Spacer(modifier = Modifier.height(16.dp))

            Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                for (i in options.indices step 2) {
                    Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                        Button(onClick = {
                            if (options[i] == options[0]) correctAnswers++ else wrongAnswers++
                            currentIndex++
                        }, modifier = Modifier.weight(1f)) {
                            Text(text = options[i])
                        }
                        if (i + 1 < options.size) {
                            Button(onClick = {
                                if (options[i + 1] == options[0]) correctAnswers++ else wrongAnswers++
                                currentIndex++
                            }, modifier = Modifier.weight(1f)) {
                                Text(text = options[i + 1])
                            }
                        }
                    }
                }
            }
        }
    }
}
