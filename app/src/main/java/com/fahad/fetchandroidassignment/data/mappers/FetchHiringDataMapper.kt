package com.fahad.fetchandroidassignment.data.mappers

import com.fahad.fetchandroidassignment.data.remote.FetchHiringDataDAO
import com.fahad.fetchandroidassignment.domain.models.HiringData


fun List<FetchHiringDataDAO>.toDomainHiringDataList(): List<List<HiringData>> {
    return this.asSequence().map {
        HiringData(
            id = it.id,
            name = it.name,
            listId = it.listId
        )
    }.filter {
        !it.name.isNullOrEmpty()
    }.sortedBy {
        it.listId
    }.sortedBy {
        it.name
    }.groupBy {
        it.listId
    }.map {
        it.value
    }.sortedBy {
        it.first().listId
    }.toList()
}