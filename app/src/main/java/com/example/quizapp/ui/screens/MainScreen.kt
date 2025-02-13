package com.example.quizapp.ui.screens


import com.example.quizapp.ui.screens.quiz.CapitalsQuizScreen
import androidx.compose.runtime.*
import com.example.quizapp.ui.screens.categories.*
import com.example.quizapp.ui.screens.quiz.*

@Composable
fun MainScreen() {
    var selectedCategory by remember { mutableStateOf<String?>(null) }
    var selectedRegion by remember { mutableStateOf<String?>(null) }

    when (selectedCategory) {
        "Флаги" -> {
            if (selectedRegion == null) {
                RegionSelectionScreen { selectedRegion = it }
            } else {
                FlagsQuizScreen(selectedRegion!!) { selectedCategory = null; selectedRegion = null }
            }
        }
        "Деньги" -> {
            if (selectedRegion == null) {
                RegionSelectionScreen { selectedRegion = it }
            } else {
                MoneyQuizScreen(selectedRegion!!) { selectedCategory = null; selectedRegion = null }
            }
        }
        "Столицы" -> {
            if (selectedRegion == null) {
                RegionSelectionScreen { selectedRegion = it }
            } else {
                CapitalsQuizScreen(selectedRegion!!) { selectedCategory = null; selectedRegion = null }
            }
        }
        else -> CategorySelectionScreen { selectedCategory = it }
    }
}
