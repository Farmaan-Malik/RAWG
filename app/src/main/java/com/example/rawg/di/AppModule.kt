package com.example.rawg.di

import com.example.rawg.BuildConfig
import com.example.rawg.data.remote.RAWGApi
import com.example.rawg.presentation.GamesListScreen.GamesListViewModel
import com.example.rawg.presentation.creatorDetailScreen.CreatorDetailViewModel
import com.example.rawg.presentation.creatorScreen.CreatorScreenViewModel
import com.example.rawg.presentation.gameDetailScreen.GameDetailScreenViewModel
import com.example.rawg.presentation.stores.StoresViewModel
import com.example.rawg.repository.RAWGrepository
import com.example.rawg.utils.Constants
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

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
   viewModel<CreatorScreenViewModel>{
        CreatorScreenViewModel(get())
   }
    viewModel<CreatorDetailViewModel>{
        CreatorDetailViewModel(get())
    }
    viewModel<StoresViewModel>{
        StoresViewModel(get())
    }
}