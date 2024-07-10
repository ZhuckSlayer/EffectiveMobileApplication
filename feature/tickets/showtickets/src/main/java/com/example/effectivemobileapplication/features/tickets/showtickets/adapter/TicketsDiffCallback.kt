package com.example.effectivemobileapplication.features.tickets.showtickets.adapter

import androidx.recyclerview.widget.DiffUtil
import com.example.effectivemobileapplication.shared.tickets.core.domain.entity.tickets.TicketInfo

class TicketsDiffCallback:DiffUtil.ItemCallback<TicketInfo>() {
    override fun areItemsTheSame(oldItem: TicketInfo, newItem: TicketInfo): Boolean {
        return oldItem.id==newItem.id
    }

    override fun areContentsTheSame(oldItem: TicketInfo, newItem: TicketInfo): Boolean {
        return oldItem==newItem
    }
}