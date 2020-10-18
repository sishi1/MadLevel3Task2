package com.example.madlevel3task2

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.madlevel3task2.databinding.CardPortalBinding


class PortalCardAdapter (val portalCards: List<PortalCard>, val clickListener:(PortalCard) -> Unit) :
    RecyclerView.Adapter<PortalCardAdapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val binding = CardPortalBinding.bind(itemView)

        fun databind(portalCard: PortalCard, clickListener: (PortalCard) -> Unit) {
            binding.tvTitle.text = portalCard.title
            binding.tvLink.text = portalCard.url
            binding.cardView.setOnClickListener { clickListener(portalCard) }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.card_portal, parent, false)
        )
    }

    override fun getItemCount(): Int {
        return portalCards.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.databind(portalCards[position], clickListener = clickListener)
    }
}