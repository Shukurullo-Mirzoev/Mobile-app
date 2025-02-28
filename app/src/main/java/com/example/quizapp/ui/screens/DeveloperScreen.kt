package com.example.quizapp.ui.screens

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.quizapp.R

@Composable
fun DeveloperScreen(onBack: () -> Unit) {
    val context = LocalContext.current

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(30.dp))

        // **Profil rasmi**
        Card(
            shape = CircleShape,
            modifier = Modifier.size(150.dp),
            elevation = CardDefaults.cardElevation(8.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.profile), // 📌 O‘zingizning rasm resursingizni qo‘shing
                contentDescription = "Profile"
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        // **Ism va lavozim**
        Text("Sizning Ismingiz", fontSize = 22.sp, fontWeight = FontWeight.Bold)
        Text("Android Developer", fontSize = 16.sp, color = Color.Gray)

        Spacer(modifier = Modifier.height(16.dp))

        // **Kontakt ma'lumotlari**
        ContactInfo(icon = R.drawable.ic_linkedin, text = "+992 88 100 18 04") {
            val intent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:+992881001804"))
            context.startActivity(intent)
        }
        ContactInfo(icon = R.drawable.ic_linkedin, text = "shukurullomirzoev2004@gmail.com") {
            val intent = Intent(Intent.ACTION_SENDTO, Uri.parse("mailto:shukurullomirzoev2004@gmail.com"))
            context.startActivity(intent)
        }
        ContactInfo(icon = R.drawable.ic_linkedin, text = "www.developer.tj") {
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.developer.tj"))
            context.startActivity(intent)
        }

        Spacer(modifier = Modifier.height(16.dp))

        // **Ijtimoiy tarmoqlar**
        Row(horizontalArrangement = Arrangement.spacedBy(16.dp)) {
            SocialButton(R.drawable.ic_instagram) {
                val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://instagram.com/yourprofile"))
                context.startActivity(intent)
            }
            SocialButton(R.drawable.ic_telegram) {
                val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://t.me/yourprofile"))
                context.startActivity(intent)
            }
            SocialButton(R.drawable.ic_linkedin) {
                val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://linkedin.com/in/yourprofile"))
                context.startActivity(intent)
            }
            SocialButton(R.drawable.ic_github) {
                val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://github.com/yourprofile"))
                context.startActivity(intent)
            }
        }


    }
}

// **Kontakt ma'lumotlarini ko‘rsatish**
@Composable
fun ContactInfo(icon: Int, text: String, onClick: () -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .height(40.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        IconButton(onClick = onClick) {
            Icon(painterResource(id = icon), contentDescription = text)
        }
        Spacer(modifier = Modifier.width(8.dp))
        Text(text, fontSize = 16.sp)
    }
}

// **Ijtimoiy tarmoq tugmalari**
@Composable
fun SocialButton(icon: Int, onClick: () -> Unit) {
    IconButton(onClick = onClick) {
        Icon(painterResource(id = icon), contentDescription = "Social Media", modifier = Modifier.size(40.dp))
    }
}




//package com.example.quizapp.ui.screens
//
//import androidx.compose.foundation.Image
//import androidx.compose.foundation.layout.Arrangement
//import androidx.compose.foundation.layout.Column
//import androidx.compose.foundation.layout.Row
//import androidx.compose.foundation.layout.Spacer
//import androidx.compose.foundation.layout.fillMaxSize
//import androidx.compose.foundation.layout.height
//import androidx.compose.foundation.layout.padding
//import androidx.compose.foundation.layout.size
//import androidx.compose.material3.Icon
//import androidx.compose.material3.IconButton
//import androidx.compose.material3.Text
//import androidx.compose.runtime.Composable
//import androidx.compose.ui.Alignment
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.graphics.Color
//import androidx.compose.ui.res.painterResource
//import androidx.compose.ui.text.font.FontWeight
//import androidx.compose.ui.unit.dp
//import androidx.compose.ui.unit.sp
//import com.example.quizapp.R
//
//
//@Composable
//fun DeveloperScreen() {
//    Column(
//        modifier = Modifier.fillMaxSize().padding(16.dp),
//        horizontalAlignment = Alignment.CenterHorizontally
//    ) {
//        Spacer(modifier = Modifier.height(30.dp))
//        Image(
//            painter = painterResource(id = R.drawable.profile),
//            contentDescription = "Profile",
//            modifier = Modifier.size(250.dp)
//        )
//        Spacer(modifier = Modifier.height(8.dp))
//        Text("Ismingiz Familiyangiz", fontSize = 20.sp, fontWeight = FontWeight.Bold)
//        Text("Android Developer", fontSize = 16.sp, color = Color.Gray)
//
//        Spacer(modifier = Modifier.height(16.dp))
//
//        // **Ijtimoiy tarmoqlar**
//        Row(horizontalArrangement = Arrangement.spacedBy(16.dp)) {
//            IconButton(onClick = { /* Instagram link */ }) {
//                Icon(painterResource(id = R.drawable.ic_instagram), contentDescription = "Instagram")
//            }
//            IconButton(onClick = { /* Telegram link */ }) {
//                Icon(painterResource(id = R.drawable.ic_telegram), contentDescription = "Telegram")
//            }
//            IconButton(onClick = { /* LinkedIn link */ }) {
//                Icon(painterResource(id = R.drawable.ic_linkedin), contentDescription = "LinkedIn")
//            }
//            IconButton(onClick = { /* GitHub link */ }) {
//                Icon(painterResource(id = R.drawable.ic_github), contentDescription = "GitHub")
//            }
//        }
//    }
//}