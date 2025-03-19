
package com.example.quizapp.ui.screens

import android.content.Context
import androidx.activity.compose.BackHandler
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
import com.google.accompanist.systemuicontroller.rememberSystemUiController
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
    val systemUiController = rememberSystemUiController()
    val appBarColor = Color(0xFF6200EA)
    val drawerState = rememberDrawerState(DrawerValue.Closed)
    val scope = rememberCoroutineScope()

    LaunchedEffect(appBarColor) {
        systemUiController.setStatusBarColor(color = appBarColor)
    }

    // Handle back button press logic
    BackHandler {
        when (selectedScreen) {
            "category" -> android.os.Process.killProcess(android.os.Process.myPid()) // Exit the app
            "region" -> selectedScreen = "category"
            "quiz" -> selectedScreen = "region"
            "developer" -> selectedScreen = "category"
        }
    }

    // Handle the drawer menu and app bar behavior
    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            DrawerMenu(
                isDarkTheme = isDarkTheme,
                selectedLanguage = selectedLanguage,
                onThemeChange = {
                    isDarkTheme = !isDarkTheme
                    prefs.edit().putBoolean("darkMode", isDarkTheme).apply()
                },
                onLanguageChange = { lang ->
                    selectedLanguage = lang
                    prefs.edit().putString("language", lang).apply()
                },
                onDeveloperContact = { selectedScreen = "developer" },
                onCloseDrawer = { scope.launch { drawerState.close() } }
            )
        }
    ) {
        MaterialTheme(colorScheme = if (isDarkTheme) darkColorScheme() else lightColorScheme()) {
            Scaffold(
                topBar = {
                    AppBar(
                        title = when (selectedScreen) {
                            "category" -> "Выберите категорию"
                            "region" -> "Выберите регион"
                            "quiz" -> selectedCategory
                            "developer" -> "О разработчике"
                            else -> ""
                        },
                        showMenu = selectedScreen == "category",
                        onNavigationClick = {
                            // Handle navigation button press based on the current screen
                            when (selectedScreen) {
                                "quiz" -> {
                                    // Back navigation when in quiz screen
                                    selectedScreen = "region"
                                }
                                "region" -> {
                                    // Back navigation when in region screen
                                    selectedScreen = "category"
                                }
                                "developer" -> {
                                    // Back navigation when in developer screen
                                    selectedScreen = "category"
                                }
                                else -> {
                                    // Open menu for category screen
                                    scope.launch { drawerState.open() }
                                }
                            }
                        }
                    )
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
                            val questions by remember(selectedCategory, selectedRegion) {
                                mutableStateOf(
                                    when (selectedCategory) {
                                        "Флаги" -> getFlagQuestions(selectedRegion)
                                        "Деньги" -> getMoneyQuestions(selectedRegion)
                                        "Столицы" -> getCapitalQuestions(selectedRegion)
                                        else -> emptyList()
                                    }
                                )
                            }
                            if (questions.isEmpty()) {
                                Text("Нет вопросов для данной категории", color = Color.Red)
                            } else {
                                QuizScreen(
                                    title = selectedCategory,
                                    questions = questions,
                                    defaultColor = appBarColor,
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