package com.example.androiddevchallenge.ui.screens

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.material.Button
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.ProgressIndicatorDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.ui.theme.MyTheme
import com.example.androiddevchallenge.ui.theme.greenDark

@Composable
fun CountDownTimerScreen(
    modifier: Modifier = Modifier
) {

    var time by rememberSaveable { mutableStateOf(60) }
    var remaining by rememberSaveable { mutableStateOf(60 * 1000L) }
    var prev by rememberSaveable { mutableStateOf(System.currentTimeMillis()) }
    var running by rememberSaveable { mutableStateOf(false) }

    Column(
        modifier = modifier
            .fillMaxHeight()
            .fillMaxWidth()
    ) {
        Box(
            modifier = modifier
                .fillMaxWidth()
                .weight(7f)
        ) {

            val animatedProgress = animateFloatAsState(
                targetValue = (remaining / 1_000f) / time,
                animationSpec = ProgressIndicatorDefaults.ProgressAnimationSpec
            ).value

//            CircularProgressIndicator(
//                progress = animatedProgress,
//                modifier = Modifier.width(120.dp)
//            )

            Text(
                text = "progress : $remaining",
                style = MaterialTheme.typography.h5,
                color = greenDark,
                modifier = Modifier.align(alignment = Alignment.Center)
            )
        }

        Row(
            modifier = modifier
                .fillMaxWidth()
                .weight(3f),
            horizontalArrangement = Arrangement.SpaceAround
        ) {
            Button(onClick = { /*TODO*/ }) {
                Text(
                    text = "Stop"
                )
            }
            Button(onClick = { /*TODO*/ }) {
                Text(
                    text = "Start"
                )
            }

        }
    }


}


@Preview
@Composable
fun PreviewTickSecond() {
    MyTheme {
        CountDownTimerScreen()
    }
}