package com.example.effectivemobileapplication.shared.tickets.core.domain.entity.offers

import com.example.effectivemobileapplication.shared.tickets.core.domain.entity.tickets.Price
import com.google.gson.annotations.SerializedName

data class Offer(
    val id:Int,
    val title:String,
    val town:String,
    val price: Price
)
