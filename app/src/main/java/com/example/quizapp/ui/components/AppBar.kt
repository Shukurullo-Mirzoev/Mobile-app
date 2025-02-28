////package com.example.quizapp.ui.components
////
////import androidx.compose.foundation.layout.*
////import androidx.compose.material.icons.Icons
////import androidx.compose.material.icons.filled.Menu
////import androidx.compose.material3.*
////import androidx.compose.runtime.Composable
////
////import androidx.compose.ui.Modifier
////import androidx.compose.ui.graphics.Color
////import androidx.compose.ui.unit.dp
////import com.example.quizapp.ui.theme.primaryColor
////
////@OptIn(ExperimentalMaterial3Api::class)
////@Composable
////fun AppBar(onMenuClick: () -> Unit) {
////    TopAppBar(
////        title = {
////            Text(text = "Выберите категорию", color = Color.White)
////        },
////        navigationIcon = {
////            IconButton(onClick = onMenuClick) {
////                Icon(Icons.Filled.Menu, contentDescription = "Меню", tint = Color.White)
////            }
////        },
////        colors = TopAppBarDefaults.topAppBarColors(
////            containerColor = primaryColor,
////            titleContentColor = Color.White
////        ),
////        modifier = Modifier
////            .fillMaxWidth()
////            .height(85.dp)
////    )
////}
////@OptIn(ExperimentalMaterial3Api::class)
////@Composable
////fun AppBar1(title: String, onMenuClick: () -> Unit) {
////    TopAppBar(
////        title = { Text(title) },
////        navigationIcon = {
////            IconButton(onClick = onMenuClick) {
////                Icon(Icons.Default.Menu, contentDescription = "Menyu")
////            }
////        }
////    )
////}

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
fun AppBar(title: String, showMenu: Boolean = false, onNavigationClick: () -> Unit) {
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
                Spacer(modifier = Modifier.width(8.dp)) // 🔹 "<" va matn orasida joy qoldiramiz
                Text(text = title, color = Color.White)
            }
        },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = primaryColor,
            titleContentColor = Color.White
        ),
        modifier = Modifier
            .fillMaxWidth()
            .height(75.dp)
    )
}


//package com.example.quizapp.ui.components
//
//import androidx.compose.foundation.layout.*
//import androidx.compose.material.icons.Icons
//import androidx.compose.material.icons.filled.ArrowBack
//import androidx.compose.material.icons.filled.Menu
//import androidx.compose.material3.*
//import androidx.compose.runtime.Composable
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.graphics.Color
//import androidx.compose.ui.unit.dp
//import androidx.compose.ui.unit.sp
//import com.example.quizapp.ui.theme.primaryColor
//
//@OptIn(ExperimentalMaterial3Api::class)
//@Composable
//fun AppBar(title: String, showMenu: Boolean = false, onNavigationClick: () -> Unit) {
//    TopAppBar(
//        title = {
//            Row(
//                modifier = Modifier.fillMaxWidth(),
//                horizontalArrangement = Arrangement.Start
//            ) {
//                IconButton(onClick = onNavigationClick) {
//                    Icon(Icons.Filled.ArrowBack, contentDescription = "Назад", tint = Color.White)
//                }
//                Spacer(modifier = Modifier.width(8.dp)) // Ikki element orasidagi masofa
//                Text(text = title, color = Color.White, fontSize = 20.sp)
//            }
//        },
//        colors = TopAppBarDefaults.topAppBarColors(
//            containerColor = primaryColor,
//            titleContentColor = Color.White
//        ),
//        modifier = Modifier
//            .fillMaxWidth()
//            .height(60.dp) // AppBar balandligi
//    )
//}
