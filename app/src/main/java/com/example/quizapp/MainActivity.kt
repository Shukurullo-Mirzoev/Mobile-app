package com.example.quizapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.quizapp.ui.screens.MainScreen


class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge() // ✅ **Status bar rangini to‘g‘ri qilish uchun**
        setContent {
            MainScreen() // 🚀 **Yangilangan MainScreen avtomatik yuklanadi!**
        }
    }
}
