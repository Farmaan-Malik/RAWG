package com.example.rawg.repository



import android.util.Log
import com.example.rawg.data.remote.RAWGApi
import com.example.rawg.data.remote.responses.ApiResponse
import com.example.rawg.data.remote.responses.Result
import com.example.rawg.utils.Resource


class RAWGrepository (
    private val Api:RAWGApi
){
    suspend fun getGames(): Resource<ApiResponse> {
        val response = try {
            Api.getGames()
        }catch (e: Exception){
            return Resource.Error(message = e.localizedMessage ?: "an error has occurred in Repository")
        }
        Log.e("Repository12", response.results.toString())
        return Resource.Success(response)
    }
}