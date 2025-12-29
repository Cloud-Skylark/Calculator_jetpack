package com.example.calculator.presentation

import com.example.calculator.domain.CalculatorOperation

data class CalculatorState(
    val number1: String = "",
    val number2: String = "",
    val operation: CalculatorOperation? = null,
    val history: List<String> = emptyList() // this will hold the history of calculations
)


