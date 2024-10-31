package com.tunahan.lottieanimationcompose

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.animateLottieCompositionAsState
import com.airbnb.lottie.compose.rememberLottieComposition

@Composable
fun Animation(innerPadding: PaddingValues) {
    var isPlaying by remember {
        mutableStateOf(true)
    }

    val lottie by rememberLottieComposition(spec = LottieCompositionSpec.RawRes(R.raw.lottie))

    val progress by animateLottieCompositionAsState(
        composition = lottie,
        isPlaying = isPlaying
    )

    LaunchedEffect(
        key1 = progress
    ) {
        if (progress == 1f) {
            isPlaying = false
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(innerPadding),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        LottieAnimation(
            composition = lottie,
            progress = { progress },
            modifier = Modifier.size(300.dp)
        )

        Button(onClick = { isPlaying = true }) {
            Text("Play again")
        }
    }
}