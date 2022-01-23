package com.app.clearscore.ui

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.lifecycle.Observer
import androidx.lifecycle.lifecycleScope
import com.app.clearscore.data.intent.ScoreIntent
import com.app.clearscore.data.state.ScoreState
import com.app.clearscore.databinding.ActivityMainBinding
import com.app.clearscore.ui.viewModel.MainViewModel
import kotlinx.coroutines.launch
import org.koin.android.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private val mViewModel by viewModel<MainViewModel>()
    private lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        mViewModel.state.observe(this, Observer {
            render(it)
        })

        // Fetching data when the application launched
        lifecycleScope.launch {
            mViewModel.intents.send(ScoreIntent.FetchData)
        }

    }

    private fun render(state: ScoreState) {
        with(state) {
            state.isLoading
            binding.progressBar.isVisible = isLoading
            state.score
            binding.scoreProgressBar.progress = score.creditReportInfo.score
            binding.tvScore.text =
                "Your Credit Score is " + score.creditReportInfo.score + " out of " + score.creditReportInfo.maxScoreValue
            if (errorMessage != null) {
                Log.e("MainActivity", errorMessage)
                Toast.makeText(this@MainActivity, errorMessage, Toast.LENGTH_SHORT).show()
            }
        }
    }
}