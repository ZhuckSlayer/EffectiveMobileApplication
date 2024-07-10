package com.example.effectivemobileapplication.features.tickets.ticketstocountry.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.effectivemobileapplication.features.tickets.ticketstocountry.R
import com.example.effectivemobileapplication.features.tickets.ticketstocountry.databinding.TicketItemBinding
import com.example.effectivemobileapplication.shared.tickets.core.domain.entity.ticketoffers.TicketOffer
import java.util.Locale

class TicketsAdapter :
    ListAdapter<TicketOffer, TicketsAdapter.TicketsViewHolder>(TicketsDiffCallback()) {

    class TicketsViewHolder(val binding: TicketItemBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TicketsViewHolder {
        val binding = TicketItemBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return TicketsViewHolder(binding)
    }

    override fun onBindViewHolder(holder: TicketsViewHolder, position: Int) {
        val binding = holder.binding
        val ticketOffer = getItem(position)

        val idImage = when (ticketOffer.id) {

            1 -> {
                R.color.orange

            }

            10 -> {
                R.color.blue
            }

            else -> {
                R.color.white
            }
        }

        binding.tvNameAvia.text = ticketOffer.title
        binding.tvTimeRange.text = ticketOffer.timeRange.joinToString()
        binding.tvPrice.text = holder.itemView.context.getString(
            R.string.priceForTicketsCountry,
            String.format(Locale.GERMANY, "%,d", ticketOffer.price.value)
                .replace(".", " ")
        )
        binding.cvColorTest.setCardBackgroundColor(holder.itemView.context.getColor(idImage))
    }
}