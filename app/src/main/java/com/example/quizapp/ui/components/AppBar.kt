package com.example.quizapp.ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.quizapp.ui.theme.primaryColor
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppBar(
    title: String,
    showMenu: Boolean = false,
    onNavigationClick: () -> Unit,
    modifier: Modifier = Modifier)
{
    TopAppBar(
        title = {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically // 🔹 Text va "<" ni bir balandlikda qiladi
            ) {
                IconButton(onClick = onNavigationClick) {
                    Icon(
                        imageVector = if (showMenu) Icons.Filled.Menu else Icons.Filled.ArrowBack,
                        contentDescription = if (showMenu) "Меню" else "Назад",
                        tint = Color.White
                    )
                }
                Spacer(modifier = Modifier.width(9.dp)) // 🔹 "<" va matn orasida joy qoldiramiz
                Text(text = title, color = Color.White)
            }
        },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = primaryColor,
            titleContentColor = Color.White
        ),
        modifier = Modifier
            .fillMaxWidth()
            .height(47.dp)  // 🔹 AppBar balandligini kamaytirdik
    )
}
