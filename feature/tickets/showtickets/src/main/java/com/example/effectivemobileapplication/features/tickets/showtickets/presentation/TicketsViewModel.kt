package com.example.effectivemobileapplication.features.tickets.showtickets.presentation

import androidx.lifecycle.ViewModel
import com.example.effectivemobileapplication.shared.tickets.core.domain.usecases.GetAllTicketsInfoUseCase
import javax.inject.Inject

class TicketsViewModel @Inject constructor(
    private val getAllTicketsInfoUseCase: GetAllTicketsInfoUseCase,
    private val router: TicketsRouter
):ViewModel() {
    val tickets=getAllTicketsInfoUseCase()

    fun close(){
        router.exit()
    }
}