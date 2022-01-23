package com.app.clearscore.ui.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.app.bbcapp.network.ApiInterface
import com.app.clearscore.core.IModel
import com.app.clearscore.data.intent.ScoreIntent
import com.app.clearscore.data.state.ScoreState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.consumeAsFlow
import kotlinx.coroutines.launch

class MainViewModel(private val apiInterface: ApiInterface) : ViewModel(),
    IModel<ScoreState, ScoreIntent> {
    override val intents: Channel<ScoreIntent> = Channel(Channel.UNLIMITED)
    private val _state = MutableLiveData<ScoreState>().apply { value = ScoreState() }
    override val state: LiveData<ScoreState>
        get() = _state

    init {
        handlerIntent()
    }

    private fun handlerIntent() {
        viewModelScope.launch {
            intents.consumeAsFlow().collect { scoreIntent ->
                when (scoreIntent) {
                    ScoreIntent.FetchData -> fetchData()
                }
            }
        }
    }

    private suspend fun fetchData() {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                updateState { ScoreState(isLoading = true) }
                updateState {
                    ScoreState(
                        isLoading = false, score = apiInterface.getData()
                    )
                }
            } catch (e: Exception) {
                updateState { ScoreState(isLoading = false, errorMessage = e.message) }
            }
        }
    }

    private suspend fun updateState(handler: suspend (intent: ScoreState) -> ScoreState) {
        _state.postValue(handler(state.value!!))
    }
}