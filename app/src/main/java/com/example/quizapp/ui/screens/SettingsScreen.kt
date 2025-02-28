//package com.example.quizapp.ui.screens
//
////noinspection UsingMaterialAndMaterial3Libraries
//import androidx.compose.foundation.layout.*
////noinspection UsingMaterialAndMaterial3Libraries
//import androidx.compose.material.*
//import androidx.compose.material3.Button
//import androidx.compose.material3.ExperimentalMaterial3Api
//import androidx.compose.material3.MaterialTheme
//import androidx.compose.material3.Scaffold
//import androidx.compose.material3.Switch
//import androidx.compose.material3.Text
//import androidx.compose.material3.TopAppBar
//import androidx.compose.runtime.*
//import androidx.compose.ui.Alignment
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.unit.dp
//import androidx.compose.ui.unit.sp
//
//@OptIn(ExperimentalMaterial3Api::class)
//@Composable
//fun SettingsScreen(onBack: () -> Unit) {
//    var isDarkTheme by remember { mutableStateOf(false) }
//
//    Scaffold(
//        topBar = {
//            TopAppBar(
//                title = {
//                    Text(
//                        "Настройки",
//                        fontSize = 20.sp,
//                        color = MaterialTheme.colors.onPrimary
//                    )
//                },
//                backgroundColor = MaterialTheme.colors.primary
//            )
//        }
//    ) { paddingValues ->
//        Column(
//            modifier = Modifier
//                .fillMaxSize()
//                .padding(paddingValues)
//                .padding(16.dp),
//            horizontalAlignment = Alignment.CenterHorizontally,
//            verticalArrangement = Arrangement.Center
//        ) {
//            Text("Тема", fontSize = 18.sp)
//            Row(verticalAlignment = Alignment.CenterVertically) {
//                Text("Светлая")
//                Switch(checked = isDarkTheme, onCheckedChange = { isDarkTheme = it })
//                Text("Тёмная")
//            }
//            Spacer(modifier = Modifier.height(20.dp))
//
//            Button(onClick = { onBack() }) {
//                Text("Orqaga")
//            }
//        }
//    }
//}
////
////package com.example.quizapp.ui.screens
////
////import androidx.compose.foundation.layout.*
////import androidx.compose.material3.*
////import androidx.compose.runtime.*
////import androidx.compose.ui.Alignment
////import androidx.compose.ui.Modifier
////import androidx.compose.ui.unit.dp
////import androidx.compose.ui.unit.sp
////
////@OptIn(ExperimentalMaterial3Api::class)
////@Composable
////fun SettingsScreen(onBack: () -> Unit) {
////    var isDarkTheme by remember { mutableStateOf(false) }
////
////    Scaffold(
////        topBar = {
////            TopAppBar(
////                title = { Text("Настройки", fontSize = 20.sp, color = MaterialTheme.colorScheme.onPrimary) },
////                colors = TopAppBarDefaults.topAppBarColors(containerColor = MaterialTheme.colorScheme.primary)
////            )
////        }
////    ) { paddingValues ->
////        Column(
////            modifier = Modifier
////                .fillMaxSize()
////                .padding(paddingValues)
////                .padding(16.dp),
////            horizontalAlignment = Alignment.CenterHorizontally,
////            verticalArrangement = Arrangement.Center
////        ) {
////            Text("Тема", fontSize = 18.sp)
////            Row(verticalAlignment = Alignment.CenterVertically) {
////                Text("Светлая")
////                Switch(checked = isDarkTheme, onCheckedChange = { isDarkTheme = it })
////                Text("Тёмная")
////            }
////            Spacer(modifier = Modifier.height(20.dp))
////
////            Button(onClick = { onBack() }) {
////                Text("Назад")
////            }
////        }
////    }
////}
