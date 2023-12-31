package com.example.jettrivia.component

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.jettrivia.utils.Colors

@Preview
@Composable
fun Question(
    modifier:Modifier=Modifier,
    question:String="Hi"
) {
    Text(
        text = question,
        fontWeight = FontWeight.SemiBold,
        color = Color.LightGray,
        fontSize = 25.sp,
        modifier = modifier.padding(
            top=10.dp
        )
        )
}