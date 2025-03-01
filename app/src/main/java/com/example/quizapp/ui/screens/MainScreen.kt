package com.example.quizapp.ui.screens

import android.content.Context
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.example.quizapp.data.getCapitalQuestions
import com.example.quizapp.data.getFlagQuestions
import com.example.quizapp.data.getMoneyQuestions
import com.example.quizapp.ui.components.AppBar
import com.example.quizapp.ui.components.DrawerMenu
import com.example.quizapp.ui.screens.quiz.QuizScreen
import kotlinx.coroutines.launch


@Composable
fun MainScreen() {
    val context = LocalContext.current
    val prefs = remember { context.getSharedPreferences("settings", Context.MODE_PRIVATE) }
    var selectedScreen by remember { mutableStateOf("category") }
    var selectedCategory by remember { mutableStateOf("") }
    var selectedRegion by remember { mutableStateOf("") }
    var isDarkTheme by remember { mutableStateOf(prefs.getBoolean("darkMode", false)) }
    var selectedLanguage by remember { mutableStateOf(prefs.getString("language", "Русский") ?: "Русский") }

    val drawerState = rememberDrawerState(DrawerValue.Closed)
    val scope = rememberCoroutineScope()

    MaterialTheme(colorScheme = if (isDarkTheme) darkColorScheme() else lightColorScheme()) {
        ModalNavigationDrawer(
            drawerState = drawerState,
            drawerContent = {
                if (selectedScreen == "category") {
                    DrawerMenu(
                        isDarkTheme = isDarkTheme,
                        onThemeChange = {
                            isDarkTheme = !isDarkTheme
                            prefs.edit().putBoolean("darkMode", isDarkTheme).apply()
                        },
                        selectedLanguage = selectedLanguage,
                        onLanguageChange = { newLanguage ->
                            selectedLanguage = newLanguage
                            prefs.edit().putString("language", selectedLanguage).apply()
                        },
                        onDeveloperContact = { // ✅ Nom to‘g‘ri
                            selectedScreen = "developer"
                            scope.launch { drawerState.close() }
                        },
                        onCloseDrawer = { scope.launch { drawerState.close() } }
                    )
                }
            }
        ) {
            Scaffold(
                topBar = {
                    when (selectedScreen) {
                        "category" -> AppBar(title = "Выберите категорию", showMenu = true) {
                            scope.launch { drawerState.open() }
                        }
                        "region" -> AppBar(title = "Выберите регион", showMenu = false) {
                            selectedScreen = "category"
                        }
                        "quiz" -> AppBar(title = selectedCategory, showMenu = false) {
                            selectedScreen = "region"
                        }
                        "developer" -> AppBar(title = "О разработчике", showMenu = false) {
                            selectedScreen = "category"
                        }
                    }
                }
            ) { paddingValues ->
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(paddingValues)
                        .padding(16.dp)
                ) {
                    when (selectedScreen) {
                        "category" -> CategorySelectionScreen { category ->
                            selectedCategory = category
                            selectedScreen = "region"
                        }
                        "region" -> RegionSelectionScreen(
                            selectedCategory = selectedCategory,
                            onRegionSelected = { region ->
                                selectedRegion = region
                                selectedScreen = "quiz"
                            },
                            onBack = { selectedScreen = "category" }
                        )
                        "quiz" -> {
                            val questions = when (selectedCategory) {
                                "Флаги" -> getFlagQuestions(selectedRegion)
                                "Деньги" -> getMoneyQuestions(selectedRegion)
                                "Столицы" -> getCapitalQuestions(selectedRegion)
                                else -> emptyList()
                            }

                            if (questions.isEmpty()) {
                                selectedScreen = "category"
                            } else {
                                QuizScreen(
                                    title = selectedCategory,
                                    questions = questions,
                                    defaultColor = Color(0xFF6200EA),  // Pass defaultColor here
                                    onBack = { selectedScreen = "region" },
                                    onQuizFinished = { selectedScreen = "category" }
                                )
                            }
                        }

                        "developer" -> DeveloperScreen(onBack = { selectedScreen = "category" })
                    }
                }
            }
        }
    }
}



//@Composable
//fun MainScreen() {
//    var selectedScreen by remember { mutableStateOf("category") }
//    var selectedCategory by remember { mutableStateOf("") }
//    var selectedRegion by remember { mutableStateOf("") }
//    var isDarkTheme by remember { mutableStateOf(false) }
//    var selectedLanguage by remember { mutableStateOf("Русский") }
//
//    val drawerState = rememberDrawerState(DrawerValue.Closed)
//    val scope = rememberCoroutineScope()
//
//    ModalNavigationDrawer(
//        drawerState = drawerState,
//        drawerContent = {
//            if (selectedScreen == "category") {  // ✅ Faqat asosiy ekranda menyu chiqadi
//                DrawerMenu(
//                    isDarkTheme = isDarkTheme,
//                    onThemeChange = { isDarkTheme = !isDarkTheme },
//                    onLanguageChange = { selectedLanguage = it }
//                )
//            }
//        }
//    ) {
//        Scaffold(
//            topBar = {
//                when (selectedScreen) {
//                    "category" -> AppBar(title = "Выберите категорию", showMenu = true) {
//                        scope.launch { drawerState.open() }
//                    }
//                    "region" -> AppBar(title = "Выберите регион", showMenu = false) {
//                        selectedScreen = "category"
//                    }
//                    "quiz" -> AppBar(title = selectedCategory, showMenu = false) {
//                        selectedScreen = "region"
//                    }
//                }
//            }
//        ) { paddingValues ->
//            Column(
//                modifier = Modifier
//                    .fillMaxSize()
//                    .padding(paddingValues)
//                    .padding(16.dp)
//            ) {
//                when (selectedScreen) {
//                    "category" -> CategorySelectionScreen { category ->
//                        selectedCategory = category
//                        selectedScreen = "region"
//                    }
//
//                    "region" -> RegionSelectionScreen(
//                        selectedCategory = selectedCategory,
//                        onRegionSelected = { region ->
//                            selectedRegion = region
//                            selectedScreen = "quiz"
//                        },
//                        onBack = { selectedScreen = "category" }
//                    )
//
//                    "quiz" -> {
//                        val questions = when (selectedCategory) {
//                            "Флаги" -> getFlagQuestions(selectedRegion)
//                            "Деньги" -> getMoneyQuestions(selectedRegion)
//                            "Столицы" -> getCapitalQuestions(selectedRegion)
//                            else -> emptyList()
//                        }
//
//                        if (questions.isEmpty()) {
//                            selectedScreen = "category"
//                        } else {
//                            QuizScreen(
//                                title = selectedCategory,
//                                questions = questions,
//                                buttonColor = MaterialTheme.colorScheme.primary,
//                                onBack = { selectedScreen = "region" }
//                            ) {
//                                selectedScreen = "category"
//                            }
//                        }
//                    }
//                }
//            }
//        }
//    }
//}
//
//@Composable
//fun MainScreen() {
//    val context = LocalContext.current
//    val prefs = remember { context.getSharedPreferences("settings", Context.MODE_PRIVATE) }
//
//    var selectedScreen by remember { mutableStateOf("category") }
//    var selectedCategory by remember { mutableStateOf("") }
//    var selectedRegion by remember { mutableStateOf("") }
//    var isDarkTheme by remember { mutableStateOf(prefs.getBoolean("darkMode", false)) } // ✅ **Saqlangan rejimni yuklash**
//    var selectedLanguage by remember { mutableStateOf(prefs.getString("language", "Русский") ?: "Русский") } // ✅ **Saqlangan tilni yuklash**
//
//    val drawerState = rememberDrawerState(DrawerValue.Closed)
//    val scope = rememberCoroutineScope()
//
//    ModalNavigationDrawer(
//        drawerState = drawerState,
//        drawerContent = {
//            if (selectedScreen == "category") {
//                DrawerMenu(
//                    isDarkTheme = isDarkTheme,
//                    onThemeChange = { isDarkTheme = it },
//                    selectedLanguage = selectedLanguage,
//                    onLanguageChange = { selectedLanguage = it }
//                )
//            }
//        }
//    ) {
//        Scaffold(
//            topBar = {
//                when (selectedScreen) {
//                    "category" -> AppBar(title = "Выберите категорию", showMenu = true) {
//                        scope.launch { drawerState.open() }
//                    }
//                    "region" -> AppBar(title = "Выберите регион", showMenu = false) {
//                        selectedScreen = "category"
//                    }
//                    "quiz" -> AppBar(title = selectedCategory, showMenu = false) {
//                        selectedScreen = "region"
//                    }
//                }
//            }
//        ) { paddingValues ->
//            Column(
//                modifier = Modifier
//                    .fillMaxSize()
//                    .padding(paddingValues)
//                    .padding(16.dp)
//            ) {
//                when (selectedScreen) {
//                    "category" -> CategorySelectionScreen { category ->
//                        selectedCategory = category
//                        selectedScreen = "region"
//                    }
//                    "region" -> RegionSelectionScreen(
//                        selectedCategory = selectedCategory,
//                        onRegionSelected = { region ->
//                            selectedRegion = region
//                            selectedScreen = "quiz"
//                        },
//                        onBack = { selectedScreen = "category" }
//                    )
//                    "quiz" -> {
//                        val questions = when (selectedCategory) {
//                            "Флаги" -> getFlagQuestions(selectedRegion)
//                            "Деньги" -> getMoneyQuestions(selectedRegion)
//                            "Столицы" -> getCapitalQuestions(selectedRegion)
//                            else -> emptyList()
//                        }
//
//                        if (questions.isEmpty()) {
//                            selectedScreen = "category"
//                        } else {
//                            QuizScreen(
//                                title = selectedCategory,
//                                questions = questions,
//                                buttonColor = MaterialTheme.colorScheme.primary,
//                                onBack = { selectedScreen = "region" }
//                            ) {
//                                selectedScreen = "category"
//                            }
//                        }
//                    }
//                    "developer" -> DeveloperScreen() // ✅ Dasturchi oynasi
//                }
//            }
//        }
//    }
//}
//@Composable
//fun MainScreen() {
//    val context = LocalContext.current
//    val prefs = remember { context.getSharedPreferences("settings", Context.MODE_PRIVATE) }
//
//    var selectedScreen by remember { mutableStateOf("category") }
//    var selectedCategory by remember { mutableStateOf("") }
//    var selectedRegion by remember { mutableStateOf("") }
//    var isDarkTheme by remember { mutableStateOf(prefs.getBoolean("darkMode", false)) }
//    var selectedLanguage by remember { mutableStateOf(prefs.getString("language", "Русский") ?: "Русский") }
//
//    val drawerState = rememberDrawerState(DrawerValue.Closed)
//    val scope = rememberCoroutineScope()
//
//    ModalNavigationDrawer(
//        drawerState = drawerState,
//        drawerContent = {
//            if (selectedScreen == "category") {
//                DrawerMenu(
//                    isDarkTheme = isDarkTheme,
//                    onThemeChange = { isDarkTheme = it },
//                    selectedLanguage = selectedLanguage,
//                    onLanguageChange = { selectedLanguage = it },
//                    onDeveloperClick = { // ✅ Dasturchi sahifasiga o'tish
//                        selectedScreen = "developer"
//                        scope.launch { drawerState.close() }
//                    },
//                    onCloseDrawer = { scope.launch { drawerState.close() } } // ✅ Chiqish tugmasi ishlaydi
//                )
//            }
//        }
//    ) {
//        Scaffold(
//            topBar = {
//                when (selectedScreen) {
//                    "category" -> AppBar(title = "Выберите категорию", showMenu = true) {
//                        scope.launch { drawerState.open() }
//                    }
//                    "region" -> AppBar(title = "Выберите регион", showMenu = false) {
//                        selectedScreen = "category"
//                    }
//                    "quiz" -> AppBar(title = selectedCategory, showMenu = false) {
//                        selectedScreen = "region"
//                    }
//                    "developer" -> AppBar(title = "О разработчике", showMenu = false) {
//                        selectedScreen = "category"
//                    }
//                }
//            }
//        ) { paddingValues ->
//            Column(
//                modifier = Modifier
//                    .fillMaxSize()
//                    .padding(paddingValues)
//                    .padding(16.dp)
//            ) {
//                when (selectedScreen) {
//                    "category" -> CategorySelectionScreen { category ->
//                        selectedCategory = category
//                        selectedScreen = "region"
//                    }
//                    "region" -> RegionSelectionScreen(
//                        selectedCategory = selectedCategory,
//                        onRegionSelected = { region ->
//                            selectedRegion = region
//                            selectedScreen = "quiz"
//                        },
//                        onBack = { selectedScreen = "category" }
//                    )
//                    "quiz" -> {
//                        val questions = when (selectedCategory) {
//                            "Флаги" -> getFlagQuestions(selectedRegion)
//                            "Деньги" -> getMoneyQuestions(selectedRegion)
//                            "Столицы" -> getCapitalQuestions(selectedRegion)
//                            else -> emptyList()
//                        }
//
//                        if (questions.isEmpty()) {
//                            selectedScreen = "category"
//                        } else {
//                            QuizScreen(
//                                title = selectedCategory,
//                                questions = questions,
//                                buttonColor = MaterialTheme.colorScheme.primary,
//                                onBack = { selectedScreen = "region" }
//                            ) {
//                                selectedScreen = "category"
//                            }
//                        }
//                    }
//                    "developer" -> DeveloperScreen(onBack = { selectedScreen = "category" }) // ✅ Orqaga qaytish tugmasi ishlaydi
//                }
//            }
//        }
//    }
//}