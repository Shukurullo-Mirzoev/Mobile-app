package com.example.quizapp.ui.screens.quiz

import androidx.compose.animation.*
import androidx.compose.animation.core.tween
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
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
import androidx.activity.compose.BackHandler
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import kotlinx.coroutines.launch


@OptIn(ExperimentalAnimationApi::class)
@Composable
fun QuizScreen(
    questions: List<Pair<Any, List<String>>>,
    title: String,
    defaultColor: Color,
    onBack: () -> Unit,
    onQuizFinished: () -> Unit
) {
    // Initialize the systemUiController to control system UI elements like the status bar
    val systemUiController = rememberSystemUiController()

    // Set the status bar color to the default color passed in the parameter
    LaunchedEffect(defaultColor) {
        systemUiController.setStatusBarColor(color = defaultColor)
    }

    // Handle back button press
    BackHandler {
        onBack()
    }

    var currentIndex by remember { mutableIntStateOf(0) }
    var correctAnswers by remember { mutableIntStateOf(0) }
    var wrongAnswers by remember { mutableIntStateOf(0) }
    var selectedAnswer by remember { mutableStateOf<String?>(null) }
    var isOptionClickable by remember { mutableStateOf(true) }
    var quizFinished by remember { mutableStateOf(false) }
    val coroutineScope = rememberCoroutineScope()

    // If the quiz is finished, show the result screen
    if (quizFinished) {
        ResultScreen(correctAnswers, wrongAnswers, onQuizFinished)
        return
    }

    val (question, options) = questions[currentIndex]
    val correctAnswer = options[0]
    var shuffledOptions by remember(currentIndex) { mutableStateOf(options.shuffled()) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "${currentIndex + 1}/${questions.size}",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold
        )
        Spacer(modifier = Modifier.height(20.dp))

        Column(
            modifier = Modifier
                .fillMaxHeight()
                .wrapContentHeight(align = Alignment.CenterVertically),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            AnimatedContent(
                targetState = question,
                transitionSpec = {
                    fadeIn(animationSpec = tween(600)) + scaleIn(initialScale = 0.8f) with fadeOut(animationSpec = tween(300))
                },
                label = "Flag Animation"
            ) { targetQuestion ->
                Card(
                    shape = RoundedCornerShape(14.dp),
                    border = BorderStroke(2.dp, Color.Gray),
                    modifier = Modifier
                        .shadow(4.dp)
                        .fillMaxWidth(0.8f)
                        .height(160.dp)
                ) {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .fillMaxHeight()
                            .wrapContentHeight(align = Alignment.CenterVertically),
                        contentAlignment = Alignment.Center
                    ) {
                        when (targetQuestion) {
                            is Int -> Image(
                                painter = painterResource(id = targetQuestion),
                                contentDescription = null,
                                modifier = Modifier.size(200.dp)
                            )
                            is String -> Text(
                                text = targetQuestion,
                                fontSize = 24.sp,
                                fontWeight = FontWeight.Bold,
                                textAlign = TextAlign.Center
                            )
                        }
                    }
                }
            }

            Spacer(modifier = Modifier.height(24.dp))

            Column(
                verticalArrangement = Arrangement.spacedBy(20.dp)
            ) {
                shuffledOptions.chunked(2).forEach { rowOptions ->
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.spacedBy(16.dp)
                    ) {
                        rowOptions.forEach { option ->
                            AnswerButton(
                                text = option,
                                selectedAnswer = selectedAnswer,
                                correctAnswer = correctAnswer,
                                isOptionClickable = isOptionClickable,
                                defaultColor = defaultColor,
                                modifier = Modifier.weight(1f),
                                onClick = {
                                    if (isOptionClickable) {
                                        selectedAnswer = option
                                        isOptionClickable = false
                                        if (option == correctAnswer) correctAnswers++ else wrongAnswers++

                                        coroutineScope.launch {
                                            delay(800)
                                            if (currentIndex + 1 < questions.size) {
                                                currentIndex++
                                                selectedAnswer = null
                                                isOptionClickable = true
                                            } else {
                                                quizFinished = true
                                            }
                                        }
                                    }
                                }
                            )
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun AnswerButton(
    text: String,
    selectedAnswer: String?,
    correctAnswer: String,
    isOptionClickable: Boolean,
    defaultColor: Color,
    modifier: Modifier = Modifier,
    onClick: () -> Unit
) {
    val animatedColor by animateColorAsState(
        targetValue = when {
            selectedAnswer == text && text == correctAnswer -> Color.Green
            selectedAnswer == text && text != correctAnswer -> Color.Red
            else -> defaultColor
        },
        animationSpec = tween(750), label = ""
    )

    Button(
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(containerColor = animatedColor),
        modifier = modifier.height(60.dp),
        shape = RoundedCornerShape(12.dp)
    ) {
        Text(
            text = text,
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center,
            maxLines = 4,
            modifier = Modifier.fillMaxWidth()
        )
    }
}