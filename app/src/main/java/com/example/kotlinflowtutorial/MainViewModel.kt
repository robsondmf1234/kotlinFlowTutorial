package com.example.kotlinflowtutorial

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

// Declaração da classe MainViewModel que herda de ViewModel
class MainViewModel : ViewModel() {

    // Declaração de uma variável 'languagesData' do tipo LiveData<String>
    val languagesData: LiveData<String> = getLanguages().asLiveData()


    // Função que retorna um Flow<String>
    fun getLanguages(): Flow<String> {

        // Usa o construtor 'flow' para criar um novo Flow.
        // O bloco dentro de 'flow { ... }' é chamado de produtor do Flow.
        return flow {
            // Define uma lista de strings representando linguagens de programação.
            // Note que há algumas duplicatas na lista (C++, C#, Swift, Ruby, PHP, Go, Rust, TypeScript, Dart, R).
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
                "Shell (Bash)",
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
            )
            // Itera sobre a lista de linguagens.
            for (language in languages) {
                // Emite cada linguagem para o Flow.
                // 'emit' é uma função de suspensão que envia um valor para o coletor do Flow.
                emit(language)
                // Simula um atraso de 1 segundo (1000 milissegundos) entre as emissões.
                // 'kotlinx.coroutines.delay(1000L)' é uma função de suspensão que pausa a corrotina
                // sem bloquear a thread.
                delay(1000L)
            }
        }
    }
}
