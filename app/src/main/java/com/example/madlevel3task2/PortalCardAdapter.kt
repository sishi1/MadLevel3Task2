package com.example.madlevel3task2

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.card_portal.view.*


class PortalCardAdapter (val portalCards: List<PortalCard>, val clickListener:(PortalCard) -> Unit) :
    RecyclerView.Adapter<PortalCardAdapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun databind(portalCard: PortalCard, clickListener: (PortalCard) -> Unit) {
            itemView.tvTitle.text = portalCard.title
            itemView.tvLink.text = portalCard.url
            itemView.cardView.setOnClickListener { clickListener(portalCard) }
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