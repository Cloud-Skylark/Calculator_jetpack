package com.example.calculator.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.sp

@Composable
fun CalculatorButton(
    symbol: String,
    modifier: Modifier = Modifier,
    color: Color = MaterialTheme.colorScheme.primaryContainer,
    textColor: Color = MaterialTheme.colorScheme.onPrimaryContainer,
    onClick: () -> Unit
) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = modifier
            .clip(CircleShape) // Makes the button round
            .clickable { onClick() }
            .then(modifier)
    ) {
        //  draw a circle behind the text using the color parameter
        Box(
            modifier = Modifier
                .matchParentSize()
                .clip(CircleShape)
                .background(color)
        )
        Text(
            text = symbol,
            fontSize = 36.sp,
            color = textColor
        )
    }
}