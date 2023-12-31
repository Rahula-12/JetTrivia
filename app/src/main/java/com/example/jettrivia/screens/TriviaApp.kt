package com.example.jettrivia.screens

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathEffect
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.ParagraphStyle
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.jettrivia.component.Question
import com.example.jettrivia.component.QuestionOptions
import com.example.jettrivia.data.DataOrException
import com.example.jettrivia.model.QuestionItem
import com.example.jettrivia.utils.Colors
import com.example.jettrivia.utils.Colors.mDarkPurple

@Preview
@Composable
fun TriviaApp(
    modifier: Modifier=Modifier,
    dataOrException: State<DataOrException<ArrayList<QuestionItem>, Boolean, Exception>> = mutableStateOf(DataOrException())
) {
    val questionCount=remember{
        mutableStateOf(0)
    }
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(mDarkPurple)
            .padding(20.dp)
    ) {
        val questionHeading:AnnotatedString= buildAnnotatedString {
            withStyle(
                style = SpanStyle(
                    fontWeight= FontWeight.Bold,
                    fontSize = 30.sp,
                    color = Colors.mLightGray
                ),
            ){
                append("Question ${questionCount.value}/ ")
            }

            withStyle(style = SpanStyle(color = Colors.mLightGray)){
                append("${dataOrException.value.data?.size}")
            }
        }
        Text(text = questionHeading)
        Spacer(modifier = modifier.height(20.dp))
        val pathEffect = PathEffect.dashPathEffect(floatArrayOf(10f, 10f), 0f)
        Canvas(
            Modifier
                .fillMaxWidth()
                .height(1.dp)) {
            drawLine(
                color = Colors.mLightGray,
                start = Offset(0f, 0f),
                end = Offset(size.width, 0f),
                pathEffect = pathEffect,
                strokeWidth = 3f
            )
        }
        Question(
            modifier=modifier,
            dataOrException.value.data?.get(questionCount.value)?.question?:"What is the meaning of this"
        )
        Spacer(modifier = modifier.height(200.dp))
            QuestionOptions(
                modifier=modifier,
                dataOrException.value.data?.get(questionCount.value)?.choices?: listOf<String>(),
                answer = dataOrException.value.data?.get(questionCount.value)?.answer?:""
            )
    }
}