package com.cristhian.myapplication

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class HeroAdapter (private val heroes: List<Hero>, private val context: Context) :
    RecyclerView.Adapter<HeroAdapter.HeroViewHolder>() {

    inner class HeroViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val heroImage: ImageView = itemView.findViewById(R.id.heroImage)
        val heroName: TextView = itemView.findViewById(R.id.heroName)
        val heroCompany: TextView = itemView.findViewById(R.id.heroCompany)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HeroViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.list_item, parent, false)
        return HeroViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: HeroViewHolder, position: Int) {
        val currentHero = heroes[position]
        holder.heroImage.setImageResource(currentHero.heroImage)
        holder.heroName.text = currentHero.heroName
        holder.heroCompany.text = currentHero.heroCompany

        holder.itemView.setOnClickListener {
            val intent = Intent(context, detalhes::class.java)
            intent.putExtra("heroDetails", currentHero.heroDetails)
            context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return heroes.size
    }
}