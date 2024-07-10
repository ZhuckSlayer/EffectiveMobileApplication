package com.example.effectivemobileapplication.features.tickets.ticketstocountry.adapter

import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.DiffUtil.ItemCallback
import com.example.effectivemobileapplication.shared.tickets.core.domain.entity.ticketoffers.TicketOffer

class TicketsDiffCallback:DiffUtil.ItemCallback<TicketOffer>() {
    override fun areItemsTheSame(oldItem: TicketOffer, newItem: TicketOffer): Boolean {
        return oldItem.id==newItem.id
    }

    override fun areContentsTheSame(oldItem: TicketOffer, newItem: TicketOffer): Boolean {
        return oldItem==newItem
    }
}