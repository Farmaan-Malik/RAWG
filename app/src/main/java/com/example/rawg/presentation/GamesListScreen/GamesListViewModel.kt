package com.example.rawg.presentation.GamesListScreen

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.rawg.data.remote.responses.gameList.Result
import com.example.rawg.repository.RAWGrepository
import com.example.rawg.utils.Resource
import kotlinx.coroutines.launch

class GamesListViewModel(
    private val repository: RAWGrepository
) : ViewModel() {
    private var _curPage = mutableStateOf(1)
    var curPage = _curPage.value
    private var _state = mutableStateOf<List<Result>>(listOf())
    var state: State<List<Result>> = _state
    private var _errorMessage = mutableStateOf("")
    var errorMessage: State<String> = _errorMessage
    private var _isLoading = mutableStateOf(false)
    var isLoading: State<Boolean> = _isLoading

    private var _carouselState = mutableStateOf<List<Result>>(listOf())
    var carouselState: State<List<Result>> = _carouselState



    init {
        getList()
        getCarousel()
    }

    private fun getList() {

        viewModelScope.launch {
            _isLoading.value = true
            Log.e("Heloo", repository.getGames(curPage).data?.results.toString())
            val response = repository.getGames(curPage)
            Log.e("Hiiiii", response.toString())

            if (response is Resource.Success && !response.data?.results.isNullOrEmpty()) {
                _state.value = response.data?.results!!
                _isLoading.value = false


            } else if (response is Resource.Error) {
                _errorMessage.value = response.message.toString()
                _isLoading.value = false
            }
        }
    }

    fun loadNextPage() {
        if (!_isLoading.value) {
            val nextPage = _curPage.value + 1
            viewModelScope.launch {
                _isLoading.value = true
                val response = repository.getGames(nextPage)
                Log.e("Trath", "${nextPage}")
                if (response is Resource.Success) {
                    val newData = response.data?.results!!
                    _state.value += newData
                    Log.e("ViewModelState", "${_state.value}")
                    _curPage.value = nextPage
//                    _isLoading.value= false
                } else if (response is Resource.Error) {
                    _errorMessage.value = response.message.toString()
                    Log.e("ViewModelFail", "${_errorMessage.value}")
//                    _isLoading.value= false
                }
                _isLoading.value = false

            }
        }
    }

    private fun getCarousel(){
        viewModelScope.launch {
            _isLoading.value = true
            Log.e("Heloo", repository.getGames(4).data?.results.toString())
            val response = repository.getGames(4)
            Log.e("Hiiiii", response.toString())

            if (response is Resource.Success && !response.data?.results.isNullOrEmpty()) {
                _carouselState.value = response.data?.results!!
                _isLoading.value = false


            } else if (response is Resource.Error) {
                _errorMessage.value = response.message.toString()
                _isLoading.value = false
            }
        }
    }

}