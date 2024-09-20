package com.fahad.fetchandroidassignment.ui.screens

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.fahad.fetchandroidassignment.domain.models.HiringData
import com.fahad.fetchandroidassignment.domain.repository.FetchHiringDataRepository
import com.fahad.fetchandroidassignment.utils.ResultState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeScreenViewModel @Inject constructor(
    private val fetchHiringDataRepository: FetchHiringDataRepository
) : ViewModel() {

    private var _hiringDataState =
        MutableStateFlow<ResultState<List<List<HiringData>>>>(ResultState.Loading)
    var hiringDataState = _hiringDataState.asStateFlow()

    fun getFetchHiringList() = viewModelScope.launch {
        val result = fetchHiringDataRepository.getFetchHiringList()
        _hiringDataState.value = result
    }
}