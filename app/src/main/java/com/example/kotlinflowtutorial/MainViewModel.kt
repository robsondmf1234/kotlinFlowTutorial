package com.example.kotlinflowtutorial

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class MainViewModel : ViewModel() {
    lateinit var languagesData: LiveData<String>

    fun getLanguages(): Flow<String> {

        return flow {
            val languages = listOf(
                "Python",
                "Java",
                "Kotlin",
                "JavaScript",
                "C++",
                "C#",
                "Swift",
                "Ruby",
                "PHP",
                "Go",
                "Rust",
                "TypeScript",
                "Dart",
                "R",
                "Scala",
                "Perl",
                "Haskell",
                "Lua",
                "MATLAB",
                "Shell (Bash)"
            )
            for (language in languages) {
                emit(language)
                // Simulate some delay
                kotlinx.coroutines.delay(1000L)
            }
        }
    }
}