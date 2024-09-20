package com.fahad.fetchandroidassignment.domain.repository

import com.fahad.fetchandroidassignment.domain.models.HiringData
import com.fahad.fetchandroidassignment.utils.ResultState

interface FetchHiringDataRepository {
    suspend fun getFetchHiringList():  ResultState<List<List<HiringData>>>
}