package com.example.calculator.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.calculator.domain.CalculatorAction
import com.example.calculator.domain.CalculatorOperation
import com.example.calculator.presentation.CalculatorState
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
            .background(MaterialTheme.colorScheme.background) // Uses Theme background (Dark/Light aware)
            .padding(16.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.BottomCenter),
            verticalArrangement = Arrangement.spacedBy(buttonSpacing)
        ) {
            // Display Area
            Text(
                text = state.number1 + (state.operation?.symbol ?: "") + state.number2,
                textAlign = TextAlign.End,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 32.dp),
                fontWeight = FontWeight.Light,
                fontSize = 80.sp,
                color = MaterialTheme.colorScheme.onBackground, // Adapts to Dark Mode
                maxLines = 2,
                lineHeight = 80.sp
            )

            // Button Rows
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

            // Row 7 8 9 x
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

            // Row 4 5 6 -
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

            // Row 1 2 3 +
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

            // Row 0 . =
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
                    color = MaterialTheme.colorScheme.primary, // Strong accent color
                    textColor = MaterialTheme.colorScheme.onPrimary,
                    onClick = { onAction(CalculatorAction.Calculate) }
                )
            }
        }
    }
}

