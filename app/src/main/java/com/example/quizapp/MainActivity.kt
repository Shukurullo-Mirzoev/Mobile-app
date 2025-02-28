package com.example.quizapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.*
import com.example.quizapp.data.getFlagQuestions
import com.example.quizapp.ui.screens.CategorySelectionScreen
import com.example.quizapp.ui.screens.MainScreen
import com.example.quizapp.ui.screens.RegionSelectionScreen
import com.example.quizapp.ui.screens.quiz.QuizScreen


class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge() // ✅ **Status bar rangini to‘g‘ri qilish uchun**
        setContent {
            MainScreen() // 🚀 **Yangilangan MainScreen avtomatik yuklanadi!**
        }
    }
}
