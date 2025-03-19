package com.example.quizapp.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.quizapp.R
import com.example.quizapp.ui.theme.primaryColor

@Composable
fun CategorySelectionScreen(onCategorySelected: (String) -> Unit) {
    Column(
        modifier = Modifier.fillMaxSize().padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        val categories = listOf(
            Triple("Флаги", R.drawable.ic_flag, "Флаги"),
            Triple("Деньги", R.drawable.ic_money, "Деньги"),
            Triple("Столицы", R.drawable.ic_capital, "Столицы")
        )

        categories.forEach { (text, icon, category) ->
            Button(
                onClick = { onCategorySelected(category) }, // **Region tanlash ekraniga o‘tish**
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
                    .height(70.dp),
                shape = RoundedCornerShape(12.dp),
                colors = ButtonDefaults.buttonColors(containerColor = primaryColor)
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Image(
                        painter = painterResource(id = icon),
                        contentDescription = text,
                        modifier = Modifier.size(28.dp)
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(text = text, fontSize = 20.sp, color = Color.White)
                }
            }
        }
    }
}
