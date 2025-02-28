//package com.example.quizapp.ui.screens
//
//import androidx.compose.foundation.Image
//import androidx.compose.foundation.layout.*
//import androidx.compose.foundation.shape.RoundedCornerShape
//import androidx.compose.material.icons.Icons
//import androidx.compose.material.icons.filled.Menu
//import androidx.compose.material3.*
//import androidx.compose.material3.ButtonDefaults.buttonColors
//import androidx.compose.runtime.*
//import androidx.compose.ui.Alignment
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.graphics.Color
//import androidx.compose.ui.res.painterResource
//import androidx.compose.ui.text.font.FontWeight
//import androidx.compose.ui.unit.dp
//import androidx.compose.ui.unit.sp
//import androidx.navigation.NavController
//import com.example.quizapp.R
//import com.example.quizapp.ui.theme.primaryColor
//import androidx.compose.foundation.layout.Row as Row
//import androidx.compose.material3.Button as Button1
//
//
//@Composable
//fun CategorySelectionScreen(onCategorySelected: (String) -> Unit) {
//    Column(
//        modifier = Modifier.fillMaxSize().padding(16.dp),
//        horizontalAlignment = Alignment.CenterHorizontally,
//        verticalArrangement = Arrangement.Center
//    ) {
//        val categories = listOf(
//            Triple("Флаги", R.drawable.ic_flag, "Флаги"),
//            Triple("Деньги", R.drawable.ic_money, "Деньги"),
//            Triple("Столицы", R.drawable.ic_capital, "Столицы")
//        )
//
//        categories.forEach { (text, icon, category) ->
//            Button1(
//                onClick = { onCategorySelected(category) }, // **Region tanlash ekraniga o‘tish**
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .padding(8.dp)
//                    .height(70.dp),
//                shape = RoundedCornerShape(12.dp),
//                colors = ButtonDefaults.buttonColors(containerColor = primaryColor)
//            ) {
//                Row(
//                    verticalAlignment = Alignment.CenterVertically,
//                    horizontalArrangement = Arrangement.Center,
//                    modifier = Modifier.fillMaxWidth()
//                ) {
//                    Image(
//                        painter = painterResource(id = icon),
//                        contentDescription = text,
//                        modifier = Modifier.size(28.dp)
//                    )
//                    Spacer(modifier = Modifier.width(8.dp))
//                    Text(text = text, fontSize = 20.sp, color = Color.White)
//                }
//            }
//        }
//    }
//}

//
////@OptIn(ExperimentalMaterial3Api::class)
////@Composable
////fun CategoryScreen(navController: NavController) {
////    Scaffold(
////        topBar = {
////            TopAppBar(
////                { Text("Выберите категорию", color = Color.White) }, navigationIcon = {
////                    IconButton(onClick = { /* TODO: Handle menu click */ }) {
////                        Icon(Icons.Filled.Menu, contentDescription = "Меню", tint = Color.White)
////                    }
////                },
////                backgroundColor = Color(0xFF6200EE) // To‘q binafsha (birinchi rasmga mos)
////            )
////        }
////    ) { padding ->
////        Column(
////            modifier = Modifier
////                .fillMaxSize()
////                .padding(padding)
////                .background(Color.White),
////            verticalArrangement = Arrangement.Center,
////            horizontalAlignment = Alignment.CenterHorizontally
////        ) {
////            val categories = listOf(
////                "Флаги" to Icons.Default.Flag,
////                "Деньги" to Icons.Default.AttachMoney,
////                "Столицы" to Icons.Default.LocationCity
////            )
////
////            categories.forEach { (title, icon) ->
////                Button1(
////                    { /* TODO: Navigate */ }, Modifier
////                        .fillMaxWidth(0.8f)
////                        .padding(8.dp)
////                        .height(56.dp),
////                    colors = buttonColors(backgroundColor = Color(0xFF6200EE)),
////                    shape = RoundedCornerShape(12.dp) // Tugmalarni yumshoq qilish
////                ) {
////                    Icon(imageVector = icon, contentDescription = title, tint = Color.White)
////                    Spacer(modifier = Modifier.width(8.dp))
////                    Text(title, color = Color.White, fontSize = 18.sp, fontWeight = FontWeight.Bold)
////                }
////            }
////        }
////    }
////}
////
////package com.example.quizapp.ui
////
////import androidx.compose.foundation.layout.*
//////noinspection UsingMaterialAndMaterial3Libraries
////import androidx.compose.material.*
////import androidx.compose.material3.Button
////import androidx.compose.material3.ExperimentalMaterial3Api
////import androidx.compose.material3.MaterialTheme
////import androidx.compose.material3.Scaffold
////import androidx.compose.material3.Text
////import androidx.compose.material3.TopAppBar
////import androidx.compose.runtime.Composable
////import androidx.compose.ui.Alignment
////import androidx.compose.ui.Modifier
////import androidx.compose.ui.unit.dp
////import androidx.compose.ui.unit.sp
////
////@OptIn(ExperimentalMaterial3Api::class)
////@Composable
////fun CategoryScreen(onCategorySelected: (String) -> Unit) {
////    Scaffold(
////        topBar = {
////            TopAppBar({
////                Text(
////                    "Выберите категорию",
////                    fontSize = 20.sp,
////                    color = MaterialTheme.color.onPrimary
////                )
////            }, MaterialTheme.colors.primary)
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
////            Button(onClick = { onCategorySelected("quiz") }, modifier = Modifier.fillMaxWidth()) {
////                Text("Флаги")
////            }
////            Spacer(modifier = Modifier.height(10.dp))
////            Button(onClick = { onCategorySelected("quiz") }, modifier = Modifier.fillMaxWidth()) {
////                Text("Деньги")
////            }
////            Spacer(modifier = Modifier.height(10.dp))
////            Button(onClick = { onCategorySelected("quiz") }, modifier = Modifier.fillMaxWidth()) {
////                Text("Столицы")
////            }
////            Spacer(modifier = Modifier.height(20.dp))
////            Button(onClick = { onCategorySelected("settings") }, modifier = Modifier.fillMaxWidth()) {
////                Text("Настройки")
////            }
////        }
////    }
////}
//package com.example.quizapp.ui.screens
//
//import androidx.compose.foundation.layout.*
//import androidx.compose.material3.*
//import androidx.compose.runtime.Composable
//import androidx.compose.ui.Alignment
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.unit.dp
//import androidx.compose.ui.unit.sp
//
//@OptIn(ExperimentalMaterial3Api::class)
//@Composable
//fun CategorySelectionScreen(onCategorySelected: (String) -> Unit) {
//    Scaffold(
//        topBar = {
//            TopAppBar(
//                title = { Text("Выберите категорию", fontSize = 20.sp, color = MaterialTheme.colorScheme.onPrimary) },
//                colors = TopAppBarDefaults.topAppBarColors(containerColor = MaterialTheme.colorScheme.primary)
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
//            listOf("Флаги", "Деньги", "Столицы").forEach { category ->
//                Button(
//                    onClick = { onCategorySelected(category) },
//                    modifier = Modifier
//                        .fillMaxWidth()
//                        .padding(8.dp)
//                        .height(56.dp)
//                ) {
//                    Text(category, fontSize = 18.sp)
//                }
//            }
//        }
//    }
//}

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
