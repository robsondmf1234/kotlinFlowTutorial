package com.example.kotlinflowtutorial

import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.example.kotlinflowtutorial.databinding.ActivityMainBinding
import kotlinx.coroutines.launch


class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    private val viewModel by viewModels<MainViewModel>()
    private val mainAdapter by lazy { MainAdapter() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupRecycler()
        observerFlowLanguages()
//        observerLiveDataGetLanguages()
    }

    //Observa o LiveData que retorna valores do tipo String
    private fun observerLiveDataGetLanguages() {
        viewModel.languagesData.observe(this) {
            Log.d("MainActivity", "Received language: $it")
            mainAdapter.addLanguage(it)
        }
    }

    //Observa o getLanguages() que retorna valores do tipo Flow<String>
    private fun observerFlowLanguages() {
        lifecycleScope.launch {
            viewModel.getLanguages().collect { language ->
                Log.d("MainActivity", "Received language: $language")
                mainAdapter.addLanguage(language)
            }
        }
    }

    private fun setupRecycler() {
        binding.recyclerView.run {
            setHasFixedSize(true)
            adapter = mainAdapter
        }
    }

}