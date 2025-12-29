package com.example.calculator

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.calculator.presentation.CalculatorScreen
import com.example.calculator.presentation.CalculatorViewModel
import com.example.calculator.ui.theme.CalculatorTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CalculatorTheme {
                // Initialize the ViewModel
                val viewModel = viewModel<CalculatorViewModel>()
                val state = viewModel.state

                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    CalculatorScreen(
                        state = state,
                        onAction = viewModel::onAction,
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(innerPadding)
                    )
                }
            }
        }
    }
}
