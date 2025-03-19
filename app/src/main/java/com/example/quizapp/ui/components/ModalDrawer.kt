package com.example.quizapp.ui.components

import android.annotation.SuppressLint
import android.app.Activity

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape

import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.quizapp.ui.theme.primaryColor
@SuppressLint("ContextCastToActivity")
@Composable
fun DrawerMenu(
    isDarkTheme: Boolean,
    selectedLanguage: String,
    onThemeChange: () -> Unit,
    onLanguageChange: (String) -> Unit,
    onDeveloperContact: () -> Unit, // ✅ Nom bir xil bo‘ldi
    onCloseDrawer: () -> Unit
) {
    val activity = LocalContext.current as? Activity

    // Tilga qarab tarjimalar
    val texts = when (selectedLanguage) {
        "Русский" -> {
            mapOf(
                "settings" to "⚙ Настройки",
                "chooseLanguage" to "🌍 Выберите язык",
                "darkTheme" to "🌙 Тёмная тема",
                "developerContact" to "👨‍💻 Связаться с разработчиком",
                "exit" to "Выйти из приложения"
            )
        }
        "English" -> {
            mapOf(
                "settings" to "⚙ Settings",
                "chooseLanguage" to "🌍 Choose Language",
                "darkTheme" to "🌙 Dark Theme",
                "developerContact" to "👨‍💻 Contact Developer",
                "exit" to "Exit App"
            )
        }
        "Тоҷикӣ" -> {
            mapOf(
                "settings" to "⚙ Танзимот",
                "chooseLanguage" to "🌍 Забонро интихоб кунед",
                "darkTheme" to "🌙 Темаи торик",
                "developerContact" to "👨‍💻 Бо барномасоз тамос гиред",
                "exit" to "Аз барнома бароед"
            )
        }
        "O‘zbek" -> {
            mapOf(
                "settings" to "⚙ Sozlamalar",
                "chooseLanguage" to "🌍 Tilni tanlang",
                "darkTheme" to "🌙 Qorong'u rejim",
                "developerContact" to "👨‍💻 Dasturchi bilan bog'lanish",
                "exit" to "Ilovadan chiqish"
            )
        }
        else -> {
            mapOf(
                "settings" to "⚙ Настройки",
                "chooseLanguage" to "🌍 Выберите язык",
                "darkTheme" to "🌙 Тёмная тема",
                "developerContact" to "👨‍💻 Связаться с разработчиком",
                "exit" to "Выйти из приложения"
            )
        }
    }

    Column(
        modifier = Modifier
            .fillMaxHeight()
            .fillMaxWidth(0.75f)
            .background(primaryColor)
            .padding(16.dp),
        horizontalAlignment = Alignment.Start
    ) {
        // Настройки yuqoriga joylashtirilgan va X alomati olib tashlangan
        Text(text = texts["settings"] ?: "⚙ Настройки", fontSize = 22.sp, color = Color.White)

        // Til tanlashni pastroqqa tushurish uchun Spacer
        Spacer(modifier = Modifier.height(32.dp)) // Bu yerda masofani oshirdik

        var expanded by remember { mutableStateOf(false) }
        val languages = listOf("Русский", "English", "Тоҷикӣ", "O‘zbek")

        Column {
            Text(text = texts["chooseLanguage"] ?: "🌍 Выберите язык", color = Color.White, fontSize = 18.sp)
            Button(
                onClick = { expanded = true },
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(12.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF2242BF))
            ) {
                Text(text = selectedLanguage, fontSize = 18.sp, color = Color.White)
            }

            DropdownMenu(expanded = expanded, onDismissRequest = { expanded = false }) {
                languages.forEach { lang ->
                    DropdownMenuItem(
                        text = { Text(lang, color = Color.Black) },
                        onClick = {
                            expanded = false
                            onLanguageChange(lang)
                        }
                    )
                }
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth().padding(vertical = 8.dp)
        ) {
            Text(text = texts["darkTheme"] ?: "🌙 Тёмная тема", color = Color.White, fontSize = 18.sp)
            Spacer(modifier = Modifier.weight(1f))
            Switch(
                checked = isDarkTheme,
                onCheckedChange = { onThemeChange() },
                colors = SwitchDefaults.colors(
                    checkedThumbColor = Color.White,
                    checkedTrackColor = Color(0xFF2242BF),
                    uncheckedThumbColor = Color.White,
                    uncheckedTrackColor = Color.Gray
                )
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = {
                onDeveloperContact()
                onCloseDrawer() // ✅ Dasturchi bilan bog‘langanda menyu yopiladi
            },
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(18.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF2242BF))
        ) {
            Text(text = texts["developerContact"] ?: "👨‍💻 Связаться с разработчиком", fontSize = 16.sp, color = Color.White)
        }

        Spacer(modifier = Modifier.weight(1f)) // ✅ Tugmani doim pastga joylashtirish

        Button(
            onClick = { activity?.finish() },
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(12.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Color.Red)
        ) {
            Text(text = texts["exit"] ?: "Выйти из приложения", fontSize = 18.sp, color = Color.White)
        }
    }
}

