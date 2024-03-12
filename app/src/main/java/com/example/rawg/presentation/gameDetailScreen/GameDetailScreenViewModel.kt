package com.example.rawg.presentation.gameDetailScreen

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.rawg.data.remote.responses.gameDetailsResponse.GameDetailsResponse
import com.example.rawg.repository.RAWGrepository
import com.example.rawg.utils.Resource
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class GameDetailScreenViewModel(
    private val repository:RAWGrepository): ViewModel() {
    lateinit var _gameDetails : GameDetailsResponse
    private val _isLoading = mutableStateOf(false)
    val isLoading: State<Boolean> = _isLoading
    private val _id = mutableStateOf(0)

    fun setId(id: Int){
        _id.value = id
    getGameDetails(_id.value)}

    fun getGameDetails(id: Int){
        viewModelScope.launch(){
            val response = repository.getGameDetails(id)
            if (response is Resource.Success){
                _gameDetails= response.data!!
                delay(3000)
                _isLoading.value = false
            }else if (response is Resource.Error)
            {
                Log.e("Details", response.message.toString())
//                _errorMessage.value = response.message.toString()
//                _isLoading.value = false
            }
        }
    }
}