package com.example.rawg.presentation.stores

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.rawg.data.remote.responses.stores.Game
import com.example.rawg.data.remote.responses.stores.StoreResult
import com.example.rawg.repository.RAWGrepository
import com.example.rawg.utils.Resource
import kotlinx.coroutines.launch

class StoresViewModel(
    private val repository : RAWGrepository
):ViewModel() {
    private var _state = mutableStateOf<List<StoreResult>>(listOf())
    var state : State<List<StoreResult>> = _state
    private var _isLoading = mutableStateOf(false)
    var isLoading : State<Boolean> = _isLoading


    init {
        getStoreList()
    }
    fun getStoreList(){
        viewModelScope.launch {
            _isLoading.value = true
           val response = repository.getStores()
            if (response is Resource.Success){
                _state.value = response.data?.results!!
                _isLoading.value = false
            }else if(response is Resource.Error){
                Log.e("StoreViewModel", "${response.message}")
                _isLoading.value = false
            }
        }
    }


}