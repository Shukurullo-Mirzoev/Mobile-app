package com.example.quizapp.ui.screens.quiz

import android.annotation.SuppressLint
import androidx.compose.animation.*
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.delay

//@OptIn(ExperimentalMaterial3Api::class)



/*
@SuppressLint("SuspiciousIndentation")
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

*/
@OptIn(ExperimentalAnimationApi::class)
@Composable
fun QuizScreen(
    questions: List<Pair<Any, List<String>>>,
    title: String,
    defaultColor: Color,
    onBack: () -> Unit,
    onQuizFinished: () -> Unit
) {
    var currentIndex by remember { mutableIntStateOf(0) }
    var correctAnswers by remember { mutableIntStateOf(0) }
    var wrongAnswers by remember { mutableIntStateOf(0) }
    var selectedAnswer by remember { mutableStateOf<String?>(null) }
    var shuffledOptions by remember { mutableStateOf(questions[currentIndex].second.shuffled()) }
    val totalQuestions = questions.size

    // State to track if the quiz is finished
    var quizFinished by remember { mutableStateOf(false) }

    // Check if quiz is finished, display result screen if true
    if (quizFinished) {
        ResultScreen(correctAnswers, wrongAnswers, onQuizFinished)
        return
    }

    val (question, options) = questions[currentIndex]

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Question progress (e.g., 1/10)
        Text(
            text = "${currentIndex + 1}/$totalQuestions",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold
        )

        // Question Display (Image or Text)
        AnimatedContent(
            targetState = question,
            transitionSpec = {
                fadeIn(animationSpec = tween(300)) with fadeOut(animationSpec = tween(300))
            }, label = ""
        ) { targetQuestion ->
            Box(
                modifier = Modifier
                    .fillMaxHeight(0.5f)
                    .fillMaxWidth(),
                contentAlignment = Alignment.Center
            ) {
                when (targetQuestion) {
                    is Int -> { // Flag Image
                        Box(
                            modifier = Modifier
                                .size(220.dp)
                                .shadow(6.dp, shape = RoundedCornerShape(12.dp))
                                .border(2.dp, Color.LightGray, shape = RoundedCornerShape(12.dp))
                                .background(Color.White)
                                .padding(6.dp),
                            contentAlignment = Alignment.Center
                        ) {
                            Image(
                                painter = painterResource(id = targetQuestion),
                                contentDescription = null,
                                modifier = Modifier.fillMaxSize()
                            )
                        }
                    }
                    is String -> { // Text Question
                        Text(
                            text = targetQuestion,
                            fontSize = 24.sp,
                            fontWeight = FontWeight.Bold,
                            modifier = Modifier.padding(16.dp),
                            textAlign = TextAlign.Center
                        )
                    }
                }
            }
        }

        // Answer Buttons
        Column(
            verticalArrangement = Arrangement.spacedBy(8.dp),
            modifier = Modifier.fillMaxHeight(0.9f)
        ) {
            shuffledOptions.chunked(2).forEach { rowOptions ->
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    rowOptions.forEach { option ->
                        AnswerButton(
                            text = option,
                            isCorrect = option == options[0],
                            selectedAnswer = selectedAnswer,
                            defaultColor = defaultColor,
                            modifier = Modifier.weight(1f),
                            onClick = {
                                if (selectedAnswer == null) { // Prevent multiple taps
                                    selectedAnswer = option
                                    if (option == options[0]) correctAnswers++ else wrongAnswers++
                                }
                            }
                        )
                    }
                }
            }
        }

        // Move to next question or show result
        LaunchedEffect(selectedAnswer) {
            if (selectedAnswer != null) {
                delay(500) // Pause to show feedback
                if (currentIndex + 1 < totalQuestions) {
                    currentIndex++
                    shuffledOptions = questions[currentIndex].second.shuffled() // Shuffle only when moving to the next question
                    selectedAnswer = null // Reset selection
                } else {
                    quizFinished = true // Set quizFinished to true to show ResultScreen
                }
            }
        }
    }
}

@Composable
fun AnswerButton(
    text: String,
    isCorrect: Boolean,
    selectedAnswer: String?,
    defaultColor: Color,
    modifier: Modifier = Modifier,
    onClick: () -> Unit
) {
    val backgroundColor by animateColorAsState(
        targetValue = when {
            selectedAnswer == null -> defaultColor
            selectedAnswer == text && isCorrect -> Color.Green
            selectedAnswer == text && !isCorrect -> Color.Red
            else -> defaultColor
        },
        animationSpec = tween(300), label = ""
    )

    Button(
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(containerColor = backgroundColor),
        modifier = modifier
            .height(50.dp)
            .padding(4.dp),
        enabled = selectedAnswer == null // Disable button after selection
    ) {
        Text(text = text, fontSize = 18.sp, fontWeight = FontWeight.Bold)
    }
}

/*

@Composable
fun AnswerButton(
    text: String,
    isCorrect: Boolean,
    buttonColor: Color, // ✅ Tugmalar rangi region tugmalari bilan bir xil bo‘lishi uchun
    selectedAnswer: String?,
    onClick: () -> Unit
) {
    Button(
        onClick = onClick, colors = ButtonDefaults.buttonColors(
            containerColor = when {
                selectedAnswer == null -> buttonColor // ✅ Tugma rangi region tugmasiga mos
                isCorrect -> Color.Green
                selectedAnswer == text -> Color.Red
                else -> buttonColor
            }
        ), modifier = Modifier
            .fillMaxWidth()
            .padding(4.dp)
    ) {
        Text(text = text)
    }
}
*/
/*
@Composable
fun AnswerButton(
    text: String,
    isCorrect: Boolean,
    buttonColor: Color, // ✅ Tugmalar App Bar rangi bilan bir xil
    selectedAnswer: String?,
    onClick: () -> Unit
) {
    Button(
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(
            containerColor = when {
                selectedAnswer == null -> buttonColor // ✅ Asosiy tugma rangi
                isCorrect -> Color.Green // ✅ To‘g‘ri javob – yashil
                selectedAnswer == text -> Color.Red // ✅ Noto‘g‘ri javob – qizil
                else -> buttonColor
            }
        ),
        modifier = Modifier
            .fillMaxWidth()
            .padding(4.dp)
    ) {
        Text(text = text, fontSize = 18.sp, fontWeight = FontWeight.Bold)
    }
}
*/
