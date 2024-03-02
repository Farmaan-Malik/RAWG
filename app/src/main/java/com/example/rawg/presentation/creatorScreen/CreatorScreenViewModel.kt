package com.example.rawg.presentation.creatorScreen

import android.util.Log
import androidx.compose.runtime.State
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
//    private var _curPage = mutableIntStateOf(1)
//    var curPage: State<Int> = _curPage

    init {
        getCreatorList()
    }

    private fun getCreatorList() {
        _isLoading.value = true
        viewModelScope.launch {
            val response = repository.getCreators()
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
}