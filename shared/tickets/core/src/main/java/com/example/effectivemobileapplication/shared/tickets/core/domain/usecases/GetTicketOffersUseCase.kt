package com.example.effectivemobileapplication.shared.tickets.core.domain.usecases

import com.example.effectivemobileapplication.shared.tickets.core.domain.repository.TicketsRepository
import javax.inject.Inject

class GetTicketOffersUseCase @Inject constructor(
    private val repository: TicketsRepository
) {
    operator fun invoke()=repository.getTicketOffers()
}