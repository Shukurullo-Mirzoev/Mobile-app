package com.example.quizapp.ui.screens.quiz

import androidx.compose.animation.*
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.delay

//@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun QuizScreen(
    questions: List<Pair<Any, List<String>>>,
    title: String,
    buttonColor: Color, // ✅ Tugmalar rangini region tugmalari bilan bir xil qilish uchun
    onBack: () -> Unit,
    onQuizFinished: () -> Unit
) {
    var currentIndex by remember { mutableIntStateOf(0) }
    var correctAnswers by remember { mutableIntStateOf(0) }
    var wrongAnswers by remember { mutableIntStateOf(0) }
    var selectedAnswer by remember { mutableStateOf<String?>(null) }
    val totalQuestions = questions.size

    if (currentIndex >= totalQuestions) {
        ResultScreen(correctAnswers, wrongAnswers, onQuizFinished)
        return
    }

    val (question, options) = questions[currentIndex]
    val shuffledOptions = options.shuffled() // ✅ Variantlar har doim aralashib chiqadi

        Column(
            modifier = Modifier
                .fillMaxSize()
//                .padding(paddingValues)
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top
        ) {
            Text(text = "${currentIndex + 1}/$totalQuestions", fontSize = 20.sp)
            Spacer(modifier = Modifier.height(16.dp))

            // ✅ **Bayroq yoki matnni markazga joylashtiramiz**
            AnimatedVisibility(
                visible = true,
                enter = fadeIn() + scaleIn(),
                exit = fadeOut() + scaleOut()
            ) {
                when (question) {
                    is Int -> { // ✅ Agar savol bayroq bo'lsa
                        Image(
                            painter = painterResource(id = question),
                            contentDescription = null,
                            modifier = Modifier
                                .size(220.dp) // ✅ Bayroq kattaligi
                                .shadow(4.dp, shape = RoundedCornerShape(8.dp)) // ✅ Yengil soya
                                .border(1.dp, Color.Gray, shape = RoundedCornerShape(8.dp)) // ✅ Nozik border
                                .padding(4.dp) // ✅ Ichki padding (chegarani ichiga joylash)
                        )
                    }
                    is String -> { // ✅ Agar savol matn bo‘lsa (Pul yoki Poytaxt)
                        Text(text = question, fontSize = 24.sp, modifier = Modifier.padding(16.dp))
                    }
                }



            }

            Spacer(modifier = Modifier.height(24.dp))

            // ✅ **Variantlar 4 ta bo‘lishi shart**
            Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                shuffledOptions.chunked(1).forEach { rowOptions ->
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        rowOptions.forEach { option ->
                            AnswerButton(
                                text = option,
                                isCorrect = option == options[0],
                                buttonColor = buttonColor, // ✅ Tugmalar rangi region tugmalari bilan bir xil bo‘lishi uchun
                                selectedAnswer = selectedAnswer,
                                onClick = {
                                    selectedAnswer = option
                                    if (option == options[0]) correctAnswers++ else wrongAnswers++
                                }
                            )
                        }
                    }
                }
            }

            // ✅ **Savolni o‘zgartirish uchun animatsiya**
            LaunchedEffect(selectedAnswer) {
                if (selectedAnswer != null) {
                    delay(450)
                    selectedAnswer = null
                    currentIndex++
                }
            }
        }
    }


@Composable
fun AnswerButton(
    text: String,
    isCorrect: Boolean,
    buttonColor: Color, // ✅ Tugmalar rangi region tugmalari bilan bir xil bo‘lishi uchun
    selectedAnswer: String?,
    onClick: () -> Unit
) {
    Button(
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(
            containerColor = when {
                selectedAnswer == null -> buttonColor // ✅ Tugma rangi region tugmasiga mos
                isCorrect -> Color.Green
                selectedAnswer == text -> Color.Red
                else -> buttonColor
            }
        ),
        modifier = Modifier
            .fillMaxWidth()
            .padding(4.dp)
    ) {
        Text(text = text)
    }
}
