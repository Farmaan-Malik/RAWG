package com.example.rawg.presentation.creatorScreen

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.rawg.data.remote.responses.creators.Creators
import com.example.rawg.repository.RAWGrepository
import com.example.rawg.utils.Resource
import kotlinx.coroutines.launch

class CreatorScreenViewModel(
    private val repository: RAWGrepository
) : ViewModel() {
    private var _state = mutableStateOf<List<Creators>>(listOf())
    var state: State<List<Creators>> = _state
    private var _isLoading = mutableStateOf(false)
    var isLoading: State<Boolean> = _isLoading
    private var _curPage = mutableIntStateOf(1)
    var curPage: State<Int> = _curPage

    init {
        getCreatorList(curPage.value)
    }

    private fun getCreatorList(value: Int) {
        _isLoading.value = true
        viewModelScope.launch {
            val response = repository.getCreators(value)
            Log.e("CreatorSSS", "${response.data}")
            when(response){
                is Resource.Success -> {
                   _state.value = response.data?.results!!
                    _isLoading.value = false
                }
                is Resource.Error ->{
                Log.e("CreatorError", "${response.message}")
                    _isLoading.value = false
                }
            }
        }
    }
    fun loadNextPage() {
        if (!_isLoading.value) {
            val nextPage = _curPage.intValue + 1
            viewModelScope.launch {
                _isLoading.value = true
                val response = repository.getCreators(nextPage)
                Log.e("Trath", "${nextPage}")
                if (response is Resource.Success) {
                    val newData = response.data?.results!!
                    _state.value += newData
                    Log.e("ViewModelState", "${_state.value}")
                    _curPage.value = nextPage
//                    _isLoading.value= false
                } else if (response is Resource.Error) {

//                    Log.e("ViewModelFail", "$")
//                    _isLoading.value= false
                }
                _isLoading.value = false

            }
        }
    }
}