package com.example.effectivemobileapplication.offersDto

import com.google.gson.annotations.SerializedName

data class ResponseOfferDto(
    @SerializedName("offers")
    val offers:List<OfferDto>
)
