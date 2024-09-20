package com.fahad.fetchandroidassignment.di

import com.fahad.fetchandroidassignment.BuildConfig
import com.fahad.fetchandroidassignment.data.remote.FetchAPI
import com.fahad.fetchandroidassignment.data.repositoryImpl.FetchHiringDataRepositoryImpl
import com.fahad.fetchandroidassignment.domain.repository.FetchHiringDataRepository
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideFetchApi(): FetchAPI {
        val logging = HttpLoggingInterceptor()
        logging.setLevel(HttpLoggingInterceptor.Level.BODY) // Log request and response body

        val client = OkHttpClient.Builder()
            //.addInterceptor(logging)
            .build()

        return Retrofit.Builder()
            .baseUrl(BuildConfig.API_BASE_URL)
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create()
    }

    @Provides
    @Singleton
    fun bindFetchHiringRepositoryImpl(fetchAPI: FetchAPI): FetchHiringDataRepository {
        return FetchHiringDataRepositoryImpl(fetchAPI)
    }
}