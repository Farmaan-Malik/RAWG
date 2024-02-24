package com.example.rawg.data.remote


import com.example.rawg.BuildConfig
import com.example.rawg.data.remote.responses.ApiResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface RAWGApi{


    @GET("games")
    suspend fun getGames(
        @Query("key") key:String = BuildConfig.Api_Key
    ): ApiResponse


}