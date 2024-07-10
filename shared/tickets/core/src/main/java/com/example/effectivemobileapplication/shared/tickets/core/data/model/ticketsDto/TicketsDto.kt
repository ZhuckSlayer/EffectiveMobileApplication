package com.example.effectivemobileapplication.ticketsDto

import com.google.gson.annotations.SerializedName

data class TicketsDto(
    @SerializedName("id")
    val id:Int,
    @SerializedName("badge")
    val badge:String,
    @SerializedName("price")
    val price: PriceDto,
    @SerializedName("provider_name")
    val providerName:String,
    @SerializedName("company")
    val company:String,
    @SerializedName("departure")
    val departure: DepartureDto,
    @SerializedName("arrival")
    val arrival: ArrivalDto,
    @SerializedName("has_transfer")
    val transfer:Boolean,
    @SerializedName("has_visa_transfer")
    val visaTransfer:Boolean,
    @SerializedName("luggage")
    val luggage: LuggageDto,
    @SerializedName("hand_luggage")
    val handLuggage: HandLuggageDto,
    @SerializedName("is_returnable")
    val returnable:Boolean,
    @SerializedName("is_exchangable")
    val exchangable:Boolean


)
