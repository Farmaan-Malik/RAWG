package com.example.rawg.presentation.GamesListScreen

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.rawg.data.remote.responses.Result
import com.example.rawg.repository.RAWGrepository
import com.example.rawg.utils.Resource
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class GamesListViewModel(
    private val repository:RAWGrepository
): ViewModel() {
    private var _state = mutableStateOf<List<Result>>(listOf())
    var state: State<List<Result>> = _state
    private var _errorMessage = mutableStateOf("")
    var errorMessage: State<String> = _errorMessage
    private var _isLoading = mutableStateOf(false)
    var isLoading: State<Boolean> = _isLoading
    init {
        getList()
    }
    private fun getList(){
        viewModelScope.launch{
            _isLoading.value= true
           Log.e("Heloo", repository.getGames().data?.results.toString())
            val response = repository.getGames()
            Log.e("Hiiiii", response.toString())

            if (response is Resource.Success && !response.data?.results.isNullOrEmpty()){
                _state.value = response.data?.results!!
                delay(3000)
                _isLoading.value = false
            }else if (response is Resource.Error)
            {
                _errorMessage.value = response.message.toString()
                _isLoading.value = false
            }
        }
    }
}