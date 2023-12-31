package com.example.jettrivia.component

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.RadioButton
import androidx.compose.material3.RadioButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.jettrivia.utils.Colors

@Preview
@Composable
fun QuestionOptions(
    modifier:Modifier=Modifier,
    choices:List<String> = listOf("Rahul","Diya"),
    answer:String="Diya"
) {
    val chosenIndex= remember {
        mutableStateOf(-1)
    }

    val updateChoice:(Int)->Unit = remember {
        {
            chosenIndex.value=it
        }
    }

    choices.forEachIndexed {
            index, s ->
        Row(
            modifier= modifier
                .fillMaxWidth()
//                .padding(
//                    start = 5.dp,
//                    end = 5.dp,
//                    bottom = 5.dp
//                )
                .background(
                   Color.Transparent,
                    shape = RoundedCornerShape(
                        topStart = CornerSize(20.dp),
                        topEnd = CornerSize(20.dp),
                        bottomStart = CornerSize(20.dp),
                        bottomEnd = CornerSize(20.dp)
                    ))
//                .clip(
//                    shape = RoundedCornerShape(70)
//                )
                .border(BorderStroke(3.dp,Colors.mBlue))
            ,
            verticalAlignment = Alignment.CenterVertically
        ) {
            RadioButton(
                selected = chosenIndex.value==index, onClick = {
                    chosenIndex.value=index
            },
                colors = RadioButtonDefaults.colors(
                    selectedColor = if(chosenIndex.value!=-1){when(choices[chosenIndex.value]==answer) {
                        true -> Color.Green
                        false -> Color.Red
                    }
                    }
                    else{
                        Color.Transparent
                    }
                )
            )
            Text(
                text = s,
                fontSize = 20.sp,
                color = Colors.mLightGray
            )
        }

    }
}