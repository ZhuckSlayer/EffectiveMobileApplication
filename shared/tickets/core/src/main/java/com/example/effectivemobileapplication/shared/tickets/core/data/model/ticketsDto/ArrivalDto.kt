package com.example.effectivemobileapplication.ticketsDto

import com.google.gson.annotations.SerializedName
import java.util.Date

data class ArrivalDto(
    @SerializedName("town")
    val town:String,
    @SerializedName("date")
    val date: String,
    @SerializedName("airport")
    val airportName:String
)
