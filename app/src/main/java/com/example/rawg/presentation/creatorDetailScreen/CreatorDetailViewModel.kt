package com.example.rawg.presentation.creatorDetailScreen

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.rawg.data.remote.responses.creators.creatorDetails.CreatorDetail
import com.example.rawg.repository.RAWGrepository
import com.example.rawg.utils.Resource
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class CreatorDetailViewModel(
    val repository : RAWGrepository
) : ViewModel(){

    lateinit var creatorDetails : CreatorDetail
    private var _isLoading = mutableStateOf(true)
    var isLoading : State<Boolean> = _isLoading
    private val _id = mutableStateOf(0)

    fun setId(id: Int){
        _id.value = id
        getCreatorDetails(_id.value)}

    fun getCreatorDetails(id: Int){
        viewModelScope.launch {
//            _isLoading.value = true
            val response = repository.getCreatorDetails(id)
            if(response is Resource.Success){
                creatorDetails = response.data!!
                delay(3000)
                Log.e("CreatorDetailData", "${response.data}")
                _isLoading.value = false
            }
            else{
//                _isLoading.value= false
                Log.e("CreatorDetail", "${response.message}")
            }

        }

    }


}