package com.example.quizapp.ui.screens.categories

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun RegionSelectionScreen(onRegionSelected: (String) -> Unit) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = "Выберите регион", fontSize = 28.sp)
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = { onRegionSelected("Азия") }) { Text("Азия", fontSize = 20.sp) }
        Button(onClick = { onRegionSelected("Европа") }) { Text("Европа", fontSize = 20.sp) }
        Button(onClick = { onRegionSelected("Африка") }) { Text("Африка", fontSize = 20.sp) }
        Button(onClick = { onRegionSelected("Америка") }) { Text("Америка", fontSize = 20.sp) }
        Button(onClick = { onRegionSelected("Все") }) { Text("Все", fontSize = 20.sp) }
    }
}
