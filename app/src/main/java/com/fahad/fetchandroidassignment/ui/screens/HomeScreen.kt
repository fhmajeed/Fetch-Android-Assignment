package com.fahad.fetchandroidassignment.ui.screens

import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.fahad.fetchandroidassignment.R
import com.fahad.fetchandroidassignment.domain.models.HiringData
import com.fahad.fetchandroidassignment.ui.component.TopAppBar
import com.fahad.fetchandroidassignment.ui.theme.FetchAndroidAssignmentTheme
import com.fahad.fetchandroidassignment.utils.ResultState

@Composable
fun HomeScreen(
    viewModel: HomeScreenViewModel
) {

    val fetchHiringData by viewModel.hiringDataState.collectAsState()

    Scaffold(
        topBar = {
            TopAppBar(
                appbarTitle = stringResource(id = R.string.home)
            )
        },
        content = { paddingValues ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color.White)
                    .padding(paddingValues)
                    .padding(horizontal = 8.dp),
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                when (val state = fetchHiringData) {
                    is ResultState.Success -> {
                        HomeScreenContent(
                            groupListOfHiringData = state.data
                        )
                    }

                    is ResultState.Error -> {
                        HomeScreenError(
                            errorMessage = state.exception.message.toString()
                        )
                    }

                    is ResultState.Loading -> {
                        HomeScreenLoading()
                    }
                }
            }
        }
    )

    LaunchedEffect(key1 = Unit) {
        viewModel.getFetchHiringList()
    }
}

@Composable
fun HomeScreenContent(groupListOfHiringData: List<List<HiringData>>) {
    LazyColumn(
        modifier = Modifier.padding(vertical = 8.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(groupListOfHiringData) { hiringDataList ->
            ElevatedCard(
                shape = RoundedCornerShape(8.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(8.dp))
            ) {

                Text(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 10.dp),
                    text = stringResource(R.string.list_item_heading, hiringDataList.first().listId),
                    textAlign = TextAlign.Center,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold
                )

                LazyRow(
                    modifier = Modifier.padding(bottom = 8.dp),
                    horizontalArrangement = Arrangement.spacedBy(0.dp)
                ) {
                    items(hiringDataList) { hiringDataItem ->

                        Card(
                            modifier = Modifier.padding(8.dp),
                            elevation = CardDefaults.cardElevation(2.dp)
                        ) {

                            Column(
                                modifier = Modifier
                                    .animateContentSize()
                                    .align(Alignment.CenterHorizontally)
                                    .padding(8.dp),
                                horizontalAlignment = Alignment.CenterHorizontally
                            ) {

                                Text(
                                    text = hiringDataItem.name ?: "No Name",
                                    style = MaterialTheme.typography.titleMedium
                                )

                                Text(
                                    text = hiringDataItem.id.toString(),
                                    style = MaterialTheme.typography.titleMedium,
                                )
                            }
                        }
                    }
                }

            }
        }
    }
}

@Preview
@Composable
fun HomeScreenContentPreview() = FetchAndroidAssignmentTheme {
    HomeScreenContent(
        groupListOfHiringData = listOf(
            listOf(
                HiringData(1, "item 1", 1),
                HiringData(2, "item 2", 1),
                HiringData(3, "item 3", 1),
                HiringData(2, "item 2", 1),
                HiringData(2, "item 2", 1),
                HiringData(2, "item 2", 1),
                HiringData(2, "item 2", 1),
                HiringData(2, "item 2", 1)
            ),
            listOf(HiringData(3, "item 3", 2), HiringData(4, "item 4", 2)),
            listOf(HiringData(5, "item 5", 3), HiringData(6, "item 6", 3))
        )
    )
}

@Composable
fun HomeScreenError(errorMessage: String) {
    Text(
        text = errorMessage,
        color = Color.Red,
        textAlign = TextAlign.Center,
        fontSize = 25.sp
    )
}

@Composable
fun HomeScreenLoading() {
    Box(contentAlignment = Alignment.Center) {
        CircularProgressIndicator(
            color = Color.Black,
            modifier = Modifier.align(Alignment.Center)
        )
    }
}