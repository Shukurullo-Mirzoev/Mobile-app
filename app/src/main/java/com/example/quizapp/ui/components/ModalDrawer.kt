package com.example.quizapp.ui.components

import android.annotation.SuppressLint
import android.app.Activity

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
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

    Column(
        modifier = Modifier
            .fillMaxHeight()
            .fillMaxWidth(0.75f)
            .background(primaryColor)
            .padding(16.dp),
        horizontalAlignment = Alignment.Start
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.End
        ) {
            IconButton(onClick = onCloseDrawer) {
                Icon(Icons.Filled.Close, contentDescription = "Close", tint = Color.White)
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        Text(text = "⚙ Настройки", fontSize = 22.sp, color = Color.White)

        Spacer(modifier = Modifier.height(16.dp))

        var expanded by remember { mutableStateOf(false) }
        val languages = listOf("Русский", "English", "Тоҷикӣ", "O‘zbek")

        Column {
            Text(text = "🌍 Выберите язык", color = Color.White, fontSize = 18.sp)
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
            Text(text = "🌙 Тёмная тема", color = Color.White, fontSize = 18.sp)
            Spacer(modifier = Modifier.weight(1f))
            Switch(
                checked = isDarkTheme,
                onCheckedChange = { onThemeChange() }, // ✅ To‘g‘ri ishlaydi
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
            onClick = onDeveloperContact, // ✅ To‘g‘ri nom ishlatilgan
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(18.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF2242BF))
        ) {
            Text(text = "👨‍💻 Связаться с разработчиком", fontSize = 16.sp, color = Color.White)
        }

        Spacer(modifier = Modifier.height(480.dp))

        Button(
            onClick = { activity?.finish() },
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(12.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Color.Red)
        ) {
            Text(text = "❌ Выйти из приложения", fontSize = 18.sp, color = Color.White)
        }
    }
}







//package com.example.quizapp.ui.components
//
//import android.annotation.SuppressLint
//import android.app.Activity
//import android.content.Context
//import androidx.compose.foundation.background
//import androidx.compose.foundation.layout.*
//import androidx.compose.foundation.shape.RoundedCornerShape
//import androidx.compose.material3.*
//import androidx.compose.runtime.*
//import androidx.compose.ui.Alignment
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.graphics.Color
//import androidx.compose.ui.platform.LocalContext
//import androidx.compose.ui.unit.dp
//import androidx.compose.ui.unit.sp
//import com.example.quizapp.ui.theme.primaryColor


//@SuppressLint("ContextCastToActivity")
//@Composable
//fun DrawerMenu(
//    isDarkTheme: Boolean,
//    onThemeChange: () -> Unit,
//    onLanguageChange: (String) -> Unit
//) {
//    val activity = LocalContext.current as? Activity
//
//    Column(
//        modifier = Modifier
//            .fillMaxHeight()
//            .fillMaxWidth(0.75f) // Yonidan 75% chiqadi
//            .background(primaryColor)
//            .padding(16.dp),
//        horizontalAlignment = Alignment.Start
//    ) {
//        Spacer(modifier = Modifier.height(50.dp)) // "Настройки" matnini pastga tushirish
//        Text(text = "Настройки", style = MaterialTheme.typography.headlineSmall, color = Color.White)
//
//        Spacer(modifier = Modifier.height(16.dp))
//
//        // **Tilni tanlash menyusi**
//        var expanded by remember { mutableStateOf(false) }
//        val languages = listOf("Русский", "English", "Тоҷикӣ", "O‘zbek")
//        var selectedLanguage by remember { mutableStateOf("Русский") }
//
//        Column {
//            Text(text = "Выберите язык", color = Color.White, fontSize = 18.sp)
//            Button(
//                onClick = { expanded = true },
//                modifier = Modifier.fillMaxWidth(),
//                shape = RoundedCornerShape(12.dp),
//                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF2242BF))
//            ) {
//                Text(text = selectedLanguage, fontSize = 18.sp, color = Color.White)
//            }
//
//            // **Til tanlash menyusini to‘g‘ri chiqarish**
//            DropdownMenu(expanded = expanded, onDismissRequest = { expanded = false }) {
//                languages.forEach { lang ->
//                    DropdownMenuItem(
//                        text = { Text(lang, color = Color.Black) }, // Matn qora rangda ko‘rinadi
//                        onClick = {
//                            selectedLanguage = lang
//                            expanded = false
//                            onLanguageChange(lang)  // Tilni o'zgartirish
//                        }
//                    )
//                }
//            }
//        }
//
//        Spacer(modifier = Modifier.height(16.dp))
//
//        // **Qorong‘u/Oq rejimni tanlash (Switch ko‘rinishida)**
//        Row(
//            verticalAlignment = Alignment.CenterVertically,
//            modifier = Modifier
//                .fillMaxWidth()
//                .padding(vertical = 8.dp)
//        ) {
//            Text(text = "Тёмная тема", color = Color.White, fontSize = 18.sp)
//            Spacer(modifier = Modifier.weight(1f))
//            Switch(
//                checked = isDarkTheme,
//                onCheckedChange = { onThemeChange() },
//                colors = SwitchDefaults.colors(
//                    checkedThumbColor = Color.White,
//                    checkedTrackColor = Color(0xFF2242BF), // "Русский" tugmasi bilan bir xil rang
//                    uncheckedThumbColor = Color.White,
//                    uncheckedTrackColor = Color.Gray
//                )
//            )
//        }
//
//        Spacer(modifier = Modifier.height(16.dp))
//
//        // **Dasturchi bilan bog‘lanish tugmasi**
//        Button(
//            onClick = { /* Keyin yozamiz */ },
//            modifier = Modifier.fillMaxWidth(),
//            shape = RoundedCornerShape(12.dp),
//            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF2242BF))
//        ) {
//            Text(text = "Связаться с разработчиком", fontSize = 18.sp, color = Color.White)
//        }
//
//        Spacer(modifier = Modifier.height(500.dp)) // **Ilovadan chiqish tugmasini balandroq joylashtirish**
//
//        // **Ilovadan chiqish tugmasi**
//        Button(
//            onClick = { activity?.finish() }, // Ilovani yopish
//            modifier = Modifier.fillMaxWidth(),
//            shape = RoundedCornerShape(12.dp),
//            colors = ButtonDefaults.buttonColors(containerColor = Color.Red)
//        ) {
//            Text(text = "Выйти из приложения", fontSize = 18.sp, color = Color.White)
//        }
//    }
//}


//
//@SuppressLint("CommitPrefEdits", "ContextCastToActivity")
//@Composable
//fun DrawerMenu(
//    isDarkTheme: Boolean,
//    onThemeChange: (Boolean) -> Unit,
//    selectedLanguage: String,
//    onLanguageChange: (String) -> Unit
//) {
//    val activity = LocalContext.current as? Activity
//    val context = LocalContext.current
//    val prefs = remember { context.getSharedPreferences("settings", Context.MODE_PRIVATE) }
//
//    Column(
//        modifier = Modifier
//            .fillMaxHeight()
//            .fillMaxWidth(0.75f) // Yonidan 75% chiqadi
//            .background(primaryColor)
//            .padding(16.dp),
//        horizontalAlignment = Alignment.Start
//    ) {
//        Spacer(modifier = Modifier.height(50.dp)) // "Настройки" matnini pastga tushirish
//        Text(text = "Настройки", style = MaterialTheme.typography.headlineSmall, color = Color.White)
//
//        Spacer(modifier = Modifier.height(16.dp))
//
//        // **Tilni tanlash menyusi**
//        var expanded by remember { mutableStateOf(false) }
//        val languages = listOf("Русский", "English", "Тоҷикӣ", "O‘zbek")
//        var selectedLang by remember { mutableStateOf(selectedLanguage) }
//
//        Column {
//            Text(text = "Выберите язык", color = Color.White, fontSize = 18.sp)
//            Button(
//                onClick = { expanded = true },
//                modifier = Modifier.fillMaxWidth(),
//                shape = RoundedCornerShape(12.dp),
//                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF2242BF))
//            ) {
//                Text(text = selectedLang, fontSize = 18.sp, color = Color.White)
//            }
//
//            DropdownMenu(expanded = expanded, onDismissRequest = { expanded = false }) {
//                languages.forEach { lang ->
//                    DropdownMenuItem(
//                        text = { Text(lang, color = Color.Black) },
//                        onClick = {
//                            selectedLang = lang
//                            expanded = false
//                            onLanguageChange(lang)
//                            prefs.edit().putString("language", lang).apply() // ✅ **Tanlangan tilni saqlash**
//                        }
//                    )
//                }
//            }
//        }
//
//        Spacer(modifier = Modifier.height(16.dp))
//
//        // **Qorong‘u/Oq rejimni tanlash (Switch ko‘rinishida)**
//        Row(
//            verticalAlignment = Alignment.CenterVertically,
//            modifier = Modifier
//                .fillMaxWidth()
//                .padding(vertical = 8.dp)
//        ) {
//            Text(text = "Тёмная тема", color = Color.White, fontSize = 18.sp)
//            Spacer(modifier = Modifier.weight(1f))
//            Switch(
//                checked = isDarkTheme,
//                onCheckedChange = {
//                    onThemeChange(it)
//                    prefs.edit().putBoolean("darkMode", it).apply() // ✅ **Tanlangan rejimni saqlash**
//                },
//                colors = SwitchDefaults.colors(
//                    checkedThumbColor = Color.White,
//                    checkedTrackColor = Color(0xFF2242BF),
//                    uncheckedThumbColor = Color.White,
//                    uncheckedTrackColor = Color.Gray
//                )
//            )
//        }
//
//        Spacer(modifier = Modifier.height(16.dp))
//
//        // **Dasturchi bilan bog‘lanish tugmasi**
//        Button(
//            onClick = { /* Keyin yozamiz */ },
//            modifier = Modifier.fillMaxWidth(),
//            shape = RoundedCornerShape(12.dp),
//            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF2242BF))
//        ) {
//            Text(text = "Связаться с разработчиком", fontSize = 18.sp, color = Color.White)
//        }
//
//        Spacer(modifier = Modifier.weight(1f)) // **Ilovadan chiqish tugmasini pastga tushirish**
//
//        // **Ilovadan chiqish tugmasi**
//        Button(
//            onClick = { activity?.finish() },
//            modifier = Modifier.fillMaxWidth(),
//            shape = RoundedCornerShape(12.dp),
//            colors = ButtonDefaults.buttonColors(containerColor = Color.Red)
//        ) {
//            Text(text = "Выйти из приложения", fontSize = 18.sp, color = Color.White)
//        }
//    }
//}










//package com.example.quizapp.ui.components
//
//import android.annotation.SuppressLint
//import android.app.Activity
//import androidx.compose.foundation.background
//import androidx.compose.foundation.layout.*
//import androidx.compose.foundation.shape.RoundedCornerShape
//import androidx.compose.material3.*
//import androidx.compose.runtime.*
//import androidx.compose.ui.Alignment
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.graphics.Color
//import androidx.compose.ui.platform.LocalContext
//import androidx.compose.ui.unit.dp
//import androidx.compose.ui.unit.sp
//import com.example.quizapp.ui.theme.primaryColor
//
//@SuppressLint("ContextCastToActivity")
//@Composable
//fun DrawerMenu(
//    isDarkTheme: Boolean,
//    onThemeChange: () -> Unit,
//    onLanguageChange: (String) -> Unit
//) {
//    val activity = LocalContext.current as? Activity
//
//    Column(
//        modifier = Modifier
//            .fillMaxHeight()
//            .fillMaxWidth(0.70f)
//            .background(primaryColor)
//            .padding(16.dp),
//        horizontalAlignment = Alignment.Start
//    ) {
//        Spacer(modifier = Modifier.height(80.dp))
//        Text(text = "Настройки", style = MaterialTheme.typography.headlineSmall, color = Color.White)
//
//        Spacer(modifier = Modifier.height(16.dp))
//
//        // **Tilni tanlash menyusi**
//        var expanded by remember { mutableStateOf(false) }
//        val languages = listOf("Русский", "English", "Тоҷикӣ", "O‘zbek")
//        var selectedLanguage by remember { mutableStateOf("Русский") }
//
//        Column {
//            Text(text = "Выберите язык", color = Color.White, fontSize = 18.sp)
//            Button(
//                onClick = { expanded = true },
//                modifier = Modifier.fillMaxWidth(),
//                shape = RoundedCornerShape(12.dp),
//                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF2242BF))
//            ) {
//                Text(text = selectedLanguage, fontSize = 18.sp, color = Color.White)
//            }
//
//            DropdownMenu(expanded = expanded, onDismissRequest = { expanded = false }) {
//                languages.forEach { lang ->
//                    DropdownMenuItem(
//                        text = { Text(lang, color = Color.Black) },
//                        onClick = {
//                            selectedLanguage = lang
//                            expanded = false
//                            onLanguageChange(lang)
//                        }
//                    )
//                }
//            }
//        }
//
//        Spacer(modifier = Modifier.height(200.dp))
//
//        Button(
//            onClick = { activity?.finish() },
//            modifier = Modifier.fillMaxWidth(),
//            shape = RoundedCornerShape(12.dp),
//            colors = ButtonDefaults.buttonColors(containerColor = Color.Red)
//        ) {
//            Text(text = "Выйти из приложения", fontSize = 18.sp, color = Color.White)
//        }
//    }
//}
