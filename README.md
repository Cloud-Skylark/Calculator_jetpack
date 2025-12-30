# 🧮 Modern Material 3 Calculator

A modern, fully functional Calculator application built entirely with **Kotlin** and **Jetpack Compose**. This project demonstrates the use of **MVVM Architecture** and **Material 3** design principles to create a scalable, testable, and visually adaptive Android application.

## 📸 Screenshots

Light Mode / Dark Mode 
<p align="center">
  <img src="screenshots/calculator_light.png" width="250"/>
</p>


---

## ✨ Key Features

* **Modern UI:** Built 100% with **Jetpack Compose**.
* **Material 3 Design:** Automatically adapts color schemes to system Light and Dark themes.
* **Calculation History:** Persists the last 5 calculations with options to view and clear history.
* **Smart Formatting:** Intelligent result parsing (e.g., converts `25.0` to `25` automatically).
* **Reactive State:** Uses `ViewModel` and `StateFlow` for seamless, glitch-free UI updates.

---

## 🛠 Tech Stack

* **Language:** [Kotlin](https://kotlinlang.org/)
* **UI Framework:** [Jetpack Compose](https://developer.android.com/jetpack/compose) (Material 3)
* **Architecture:** MVVM (Model-View-ViewModel)
* **State Management:** ViewModel & State Hoisting
* **Lifecycle:** AndroidX Lifecycle
* **Build System:** Gradle KTS

---

## 📂 Project Structure

The code is organized to separate business logic from UI rendering, following Clean Architecture principles:
com.example.calculator
├── data/                  # Data layer
│   └── CalculationHistory.kt  # Logic for storing history
├── ui/                    # UI Layer
│   ├── components/        # Reusable UI parts (CalculatorButton, Display)
│   ├── theme/             # Material 3 Theme & Color definitions
│   ├── CalculatorScreen.kt    # Main UI Screen
│   └── CalculatorViewModel.kt # State management & Calculation logic
└── utils/                 # Utility classes
    └── MathEvaluator.kt   # Logic for parsing expressions










└── utils/                 # Utility classes
    └── MathEvaluator.kt   # Logic for parsing expressions
