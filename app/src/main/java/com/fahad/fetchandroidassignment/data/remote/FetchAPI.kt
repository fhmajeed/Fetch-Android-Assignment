package com.fahad.fetchandroidassignment.data.remote

import retrofit2.http.GET

interface FetchAPI {
    @GET("hiring.json")
    suspend fun getFetchHiringList(): List<FetchHiringDataDAO>
}