package com.example.quizapp.ui.theme

import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.quizapp.R

@Composable
fun ThemeSwitcher(isDarkTheme: MutableState<Boolean>) {
    Row {
        Text(text = if (isDarkTheme.value) "Темная тема" else "Светлая тема")
        IconButton(onClick = { isDarkTheme.value = !isDarkTheme.value }) {
            Icon(
                painter = painterResource(id = if (isDarkTheme.value) R.drawable.ic_dark_mode else R.drawable.baseline_brightness_2_24),
                contentDescription = "Переключатель темы",
                tint = MaterialTheme.colorScheme.primary
            )
        }
        Switch(
            checked = isDarkTheme.value,
            onCheckedChange = { isDarkTheme.value = it }
        )
    }
}

@Preview
@Composable
fun PreviewThemeSwitcher() {
    // Fake state for preview
    androidx.compose.runtime.remember { androidx.compose.runtime.mutableStateOf(false) }.let {
        ThemeSwitcher(it)
    }
}
