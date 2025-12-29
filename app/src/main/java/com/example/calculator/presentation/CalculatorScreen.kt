package com.example.calculator.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.calculator.domain.CalculatorAction
import com.example.calculator.domain.CalculatorOperation
import com.example.calculator.presentation.components.CalculatorButton

@Composable
fun CalculatorScreen(
    state: CalculatorState,
    onAction: (CalculatorAction) -> Unit,
    modifier: Modifier = Modifier
) {
    val buttonSpacing = 8.dp

    Box(
        modifier = modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
            .padding(16.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.BottomCenter),
            verticalArrangement = Arrangement.spacedBy(buttonSpacing)
        ) {
            // --- NEW: History Section ---
            LazyColumn(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f) // Takes up remaining space at the top
                    .padding(bottom = 8.dp),
                verticalArrangement = Arrangement.Bottom,
                reverseLayout = true // Show newest at the bottom of the list
            ) {
                items(state.history.reversed()) { historyItem ->
                    Text(
                        text = historyItem,
                        fontSize = 20.sp,
                        color = MaterialTheme.colorScheme.secondary,
                        textAlign = TextAlign.End,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(4.dp)
                    )
                }
            }

            Divider(color = MaterialTheme.colorScheme.onBackground.copy(alpha = 0.2f))

            // Current Display Area
            Text(
                text = state.number1 + (state.operation?.symbol ?: "") + state.number2,
                textAlign = TextAlign.End,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 32.dp),
                fontWeight = FontWeight.Light,
                fontSize = 80.sp,
                color = MaterialTheme.colorScheme.onBackground,
                maxLines = 2,
                lineHeight = 80.sp
            )

            // Button Rows (Same as before)
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(buttonSpacing)
            ) {
                CalculatorButton(
                    symbol = "AC",
                    modifier = Modifier
                        .aspectRatio(2f)
                        .weight(2f),
                    color = MaterialTheme.colorScheme.secondaryContainer,
                    textColor = MaterialTheme.colorScheme.onSecondaryContainer,
                    onClick = { onAction(CalculatorAction.Clear) }
                )
                CalculatorButton(
                    symbol = "Del",
                    modifier = Modifier
                        .aspectRatio(1f)
                        .weight(1f),
                    color = MaterialTheme.colorScheme.secondaryContainer,
                    textColor = MaterialTheme.colorScheme.onSecondaryContainer,
                    onClick = { onAction(CalculatorAction.Delete) }
                )
                CalculatorButton(
                    symbol = "/",
                    modifier = Modifier
                        .aspectRatio(1f)
                        .weight(1f),
                    color = MaterialTheme.colorScheme.tertiaryContainer,
                    textColor = MaterialTheme.colorScheme.onTertiaryContainer,
                    onClick = { onAction(CalculatorAction.Operation(CalculatorOperation.Divide)) }
                )
            }
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(buttonSpacing)
            ) {
                CalculatorButton(
                    symbol = "7",
                    modifier = Modifier
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick = { onAction(CalculatorAction.Number(7)) })
                CalculatorButton(
                    symbol = "8",
                    modifier = Modifier
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick = { onAction(CalculatorAction.Number(8)) })
                CalculatorButton(
                    symbol = "9",
                    modifier = Modifier
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick = { onAction(CalculatorAction.Number(9)) })
                CalculatorButton(
                    symbol = "x",
                    modifier = Modifier
                        .aspectRatio(1f)
                        .weight(1f),
                    color = MaterialTheme.colorScheme.tertiaryContainer,
                    textColor = MaterialTheme.colorScheme.onTertiaryContainer,
                    onClick = { onAction(CalculatorAction.Operation(CalculatorOperation.Multiply)) }
                )
            }
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(buttonSpacing)
            ) {
                CalculatorButton(
                    symbol = "4",
                    modifier = Modifier
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick = { onAction(CalculatorAction.Number(4)) })
                CalculatorButton(
                    symbol = "5",
                    modifier = Modifier
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick = { onAction(CalculatorAction.Number(5)) })
                CalculatorButton(
                    symbol = "6",
                    modifier = Modifier
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick = { onAction(CalculatorAction.Number(6)) })
                CalculatorButton(
                    symbol = "-",
                    modifier = Modifier
                        .aspectRatio(1f)
                        .weight(1f),
                    color = MaterialTheme.colorScheme.tertiaryContainer,
                    textColor = MaterialTheme.colorScheme.onTertiaryContainer,
                    onClick = { onAction(CalculatorAction.Operation(CalculatorOperation.Subtract)) }
                )
            }
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(buttonSpacing)
            ) {
                CalculatorButton(
                    symbol = "1",
                    modifier = Modifier
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick = { onAction(CalculatorAction.Number(1)) })
                CalculatorButton(
                    symbol = "2",
                    modifier = Modifier
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick = { onAction(CalculatorAction.Number(2)) })
                CalculatorButton(
                    symbol = "3",
                    modifier = Modifier
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick = { onAction(CalculatorAction.Number(3)) })
                CalculatorButton(
                    symbol = "+",
                    modifier = Modifier
                        .aspectRatio(1f)
                        .weight(1f),
                    color = MaterialTheme.colorScheme.tertiaryContainer,
                    textColor = MaterialTheme.colorScheme.onTertiaryContainer,
                    onClick = { onAction(CalculatorAction.Operation(CalculatorOperation.Add)) }
                )
            }
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(buttonSpacing)
            ) {
                CalculatorButton(
                    symbol = "0",
                    modifier = Modifier
                        .aspectRatio(2f)
                        .weight(2f),
                    onClick = { onAction(CalculatorAction.Number(0)) }
                )
                CalculatorButton(
                    symbol = ".",
                    modifier = Modifier
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick = { onAction(CalculatorAction.Decimal) }
                )
                CalculatorButton(
                    symbol = "=",
                    modifier = Modifier
                        .aspectRatio(1f)
                        .weight(1f),
                    color = MaterialTheme.colorScheme.primary,
                    textColor = MaterialTheme.colorScheme.onPrimary,
                    onClick = { onAction(CalculatorAction.Calculate) }
                )
            }
        }
    }
}
