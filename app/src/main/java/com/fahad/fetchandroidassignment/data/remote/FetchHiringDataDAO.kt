package com.fahad.fetchandroidassignment.data.remote

import com.google.gson.annotations.SerializedName

data class FetchHiringDataDAO(
    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val name: String?,
    @SerializedName("listId")
    val listId: Int,
)
