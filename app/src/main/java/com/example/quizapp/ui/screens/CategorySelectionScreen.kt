package com.example.quizapp.ui.screens.categories

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun CategorySelectionScreen(onCategorySelected: (String) -> Unit) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = "Выберите категорию", fontSize = 28.sp)
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = { onCategorySelected("Флаги") }) { Text("Флаги", fontSize = 20.sp) }
        Button(onClick = { onCategorySelected("Деньги") }) { Text("Деньги", fontSize = 20.sp) }
        Button(onClick = { onCategorySelected("Столицы") }) { Text("Столицы", fontSize = 20.sp) }
    }
}
