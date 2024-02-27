package com.example.rawg.data.remote


import com.example.rawg.BuildConfig
import com.example.rawg.data.remote.responses.ApiResponse
import com.example.rawg.data.remote.responses.gameDetailsResponse.GameDetailsResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface RAWGApi{


    @GET("games")
    suspend fun getGames(
        @Query("key") key:String= BuildConfig.Api_Key,
        @Query("page") page:Int): ApiResponse

    @GET("games/{id}")
    suspend fun getGameDetails(
        @Path("id") id:Int,
        @Query("key")key:String = BuildConfig.Api_Key
    ): GameDetailsResponse
}