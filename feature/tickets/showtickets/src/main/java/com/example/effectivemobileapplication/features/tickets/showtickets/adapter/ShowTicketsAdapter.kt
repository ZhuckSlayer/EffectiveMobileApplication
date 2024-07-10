package com.example.effectivemobileapplication.features.tickets.showtickets.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.effectivemobileapplication.features.tickets.showtickets.R
import com.example.effectivemobileapplication.features.tickets.showtickets.databinding.TicketItemAllBinding
import com.example.effectivemobileapplication.shared.tickets.core.domain.entity.tickets.TicketInfo
import java.text.SimpleDateFormat
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.time.temporal.ChronoUnit
import java.util.Locale

class ShowTicketsAdapter :
    ListAdapter<TicketInfo, ShowTicketsAdapter.TicketsViewHolder>(TicketsDiffCallback()) {

    class TicketsViewHolder(val binding: TicketItemAllBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TicketsViewHolder {
        val binding = TicketItemAllBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return TicketsViewHolder(binding)
    }

    override fun onBindViewHolder(holder: TicketsViewHolder, position: Int) {
        val binding = holder.binding
        val ticketOffer = getItem(position)
        binding.tvPrice.text = holder.itemView.context.getString(
            R.string.priceForShowTickets,
            String.format(Locale.GERMANY, "%,d", ticketOffer.price.value)
                .replace(".", " ")
        )

        if (ticketOffer.badge != null) {
            binding.badge.visibility = View.VISIBLE
            binding.textBadge.text = ticketOffer.badge
        } else {
            binding.badge.visibility = View.INVISIBLE
        }

        binding.codeAirArrive.text = ticketOffer.arrival.airportName
        binding.codeAirDeparture.text = ticketOffer.departure.airportName

        binding.timeArrive.text = formatTime(ticketOffer.arrival.date.trim())
        binding.tvTimeDeparture.text = formatTime(ticketOffer.departure.date.trim())
        if (!ticketOffer.transfer)
            binding.tvTransfer.visibility = View.VISIBLE
        else
            binding.tvTransfer.visibility = View.INVISIBLE
        binding.timeFly.text = holder.itemView.context.getString(
            R.string.timeFly,
            countDiff(ticketOffer.departure.date, ticketOffer.arrival.date)
        )
    }

    fun formatTime(date: String): String {
        val parsed = LocalDateTime.parse(date, DateTimeFormatter.ISO_DATE_TIME)
        val hours = parsed.format(DateTimeFormatter.ofPattern("HH:mm"))
        return hours
    }

    fun countDiff(dateDeparture: String, dateArrive: String): String {
        val parsedDeparture = LocalDateTime.parse(
            dateDeparture,
            DateTimeFormatter.ISO_DATE_TIME
        )
        val parsedArrive = LocalDateTime.parse(
            dateArrive,
            DateTimeFormatter.ISO_DATE_TIME
        )
        val test=ChronoUnit.MILLIS.between(parsedDeparture,parsedArrive)
        val hours=test/1000/3600
        val minutes=test/1000/60%60

        return StringBuilder("$hours:$minutes").toString()
    }
}