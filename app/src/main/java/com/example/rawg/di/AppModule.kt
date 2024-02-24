package com.example.rawg.di

import com.example.rawg.BuildConfig
import com.example.rawg.data.remote.RAWGApi
import com.example.rawg.presentation.GamesListScreen.GamesListViewModel
import com.example.rawg.presentation.gameDetailScreen.GameDetailScreenViewModel
import com.example.rawg.repository.RAWGrepository
import com.example.rawg.utils.Constants
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import org.koin.dsl.single
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import retrofit2.http.GET

val appModule = module {

    single {
        Retrofit.Builder().baseUrl(Constants.Base_Url).addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(RAWGApi::class.java)
    }
    factory<RAWGrepository> { RAWGrepository(get()) }

    viewModel<GamesListViewModel>{
        GamesListViewModel(get())
    }
    viewModel<GameDetailScreenViewModel>{
        GameDetailScreenViewModel(get())
    }
}