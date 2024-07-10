package com.example.effectivemobileapplication.ticketsDto

import com.google.gson.annotations.SerializedName

data class HandLuggageDto(
    @SerializedName("has_hand_luggage")
    val handLuggage:Boolean,
    @SerializedName("size")
    val size:String
)
