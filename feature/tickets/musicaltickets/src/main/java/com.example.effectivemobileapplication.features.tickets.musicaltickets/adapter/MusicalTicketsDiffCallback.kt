package com.example.effectivemobileapplication.features.tickets.musicaltickets.adapter

import androidx.recyclerview.widget.DiffUtil
import com.example.effectivemobileapplication.shared.tickets.core.domain.entity.offers.Offer

class MusicalTicketsDiffCallback : DiffUtil.ItemCallback<Offer>() {
    override fun areItemsTheSame(oldItem: Offer, newItem: Offer): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Offer, newItem: Offer): Boolean {
        return oldItem == newItem
    }

}