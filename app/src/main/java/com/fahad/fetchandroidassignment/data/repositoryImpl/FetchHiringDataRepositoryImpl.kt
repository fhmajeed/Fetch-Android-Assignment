package com.fahad.fetchandroidassignment.data.repositoryImpl

import com.fahad.fetchandroidassignment.data.mappers.toDomainHiringDataList
import com.fahad.fetchandroidassignment.data.remote.FetchAPI
import com.fahad.fetchandroidassignment.domain.models.HiringData
import com.fahad.fetchandroidassignment.domain.repository.FetchHiringDataRepository
import com.fahad.fetchandroidassignment.utils.ResultState
import javax.inject.Inject

class FetchHiringDataRepositoryImpl @Inject constructor(
    private val api: FetchAPI
) : FetchHiringDataRepository {

    override suspend fun getFetchHiringList(): ResultState<List<List<HiringData>>> {
        return try {
            val responseHiringList = api.getFetchHiringList()
            ResultState.Success(responseHiringList.toDomainHiringDataList())
        } catch (e: Exception) {
            ResultState.Error(Exception("Network Error"))
        }
    }
}

