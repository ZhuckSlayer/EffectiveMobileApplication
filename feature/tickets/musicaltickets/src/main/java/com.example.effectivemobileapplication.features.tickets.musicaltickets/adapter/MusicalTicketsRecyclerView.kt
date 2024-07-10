package com.example.effectivemobileapplication.features.tickets.musicaltickets.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.effectivemobileapplication.features.tickets.musicaltickets.R
import com.example.effectivemobileapplication.features.tickets.musicaltickets.databinding.MusicalTicketsInfoBinding
import com.example.effectivemobileapplication.shared.tickets.core.domain.entity.offers.Offer
import java.util.Locale

class MusicalTicketsRecyclerView :
    ListAdapter<Offer, MusicalTicketsRecyclerView.MusicalTicketsInfoViewHolder>(
        MusicalTicketsDiffCallback()
    ) {
    class MusicalTicketsInfoViewHolder(val binding: MusicalTicketsInfoBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MusicalTicketsInfoViewHolder {
        val binding = MusicalTicketsInfoBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return MusicalTicketsInfoViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MusicalTicketsInfoViewHolder, position: Int) {
        val binding = holder.binding
        val musicalTicket = getItem(position)
        val idImage = when (position) {

            0 -> {
                R.drawable.dieantwood
            }

            1 -> {
                R.drawable.socratlera
            }

            else -> {
                R.drawable.lamp
            }
        }

        binding.tvPrice.text =
            holder.itemView.context.getString(
                R.string.priceForMusicalTickets,
                String.format(Locale.GERMANY, "%,d", musicalTicket.price.value)
                    .replace(".", " ")
            )
        binding.tvCityName.text = musicalTicket.town
        binding.tvNameGroup.text = musicalTicket.title
        binding.ivLogo.setImageResource(idImage)
    }
}