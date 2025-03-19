package com.example.quizapp.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.quizapp.ui.theme.primaryColor

@Composable
fun RegionSelectionScreen(selectedCategory: String, onRegionSelected: (String) -> Unit, onBack: () -> Unit) {

        Column(
            modifier = Modifier.fillMaxSize().padding(10.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            val regions = listOf("Азия", "Европа", "Африка", "Америка", "Все")

            regions.forEach { region ->
                Button(
                    onClick = { onRegionSelected(region) },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(10.dp)
                        .height(60.dp),
                    shape = RoundedCornerShape(12.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = primaryColor)
                ) {
                    Text(text = region, fontSize = 20.sp, color = Color.White)
                }
            }
        }
    }
