package com.example.quizapp.ui.screens.quiz

import androidx.compose.animation.*
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape

import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.delay

@Composable
fun ResultScreen(correct: Int, wrong: Int, onRestart: () -> Unit) {
    val total = correct + wrong

    // **Visibility state for animation**
    var isVisible by remember { mutableStateOf(false) }

    LaunchedEffect(Unit) {
        // Delay to ensure transition happens after the last question is answered
        delay(400)
        isVisible = true
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        AnimatedVisibility(
            visible = isVisible,
            enter = fadeIn() + slideInVertically(),
            exit = fadeOut() + slideOutVertically()
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color(0xFF1E88E5), shape = RoundedCornerShape(16.dp))
                    .padding(24.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                // Title and Result Info
                Text(text = "Your Result!", fontSize = 24.sp, fontWeight = FontWeight.Bold, color = Color.White)
                Spacer(modifier = Modifier.height(16.dp))

                Text(text = "Correct Answers: $correct", fontSize = 20.sp, color = Color.Green)
                Text(text = "Wrong Answers: $wrong", fontSize = 20.sp, color = Color.Red)
                Text(text = "Total Questions: $total", fontSize = 20.sp, color = Color.White)

                Spacer(modifier = Modifier.height(20.dp))

                // Restart Button
                Button(
                    onClick = onRestart,
                    colors = ButtonDefaults.buttonColors(containerColor = Color.White),
                    shape = RoundedCornerShape(12.dp),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text("🔄 Try Again.", fontSize = 18.sp, color = Color(0xFF1E88E5))
                }
            }
        }
    }
}

