package com.example.flower

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ListFlowerAdapter(private val list: ArrayList<Flower>) : RecyclerView.Adapter<ListFlowerAdapter.ListViewHolder>() {

    inner class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var name: TextView = itemView.findViewById(R.id.tv_flower_name)
        var description: TextView = itemView.findViewById(R.id.tv_flower_description)
        var photo: ImageView = itemView.findViewById(R.id.img_flower)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_flower, parent, false)
        return ListViewHolder(view)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val flower = list[position]
        holder.name.text = flower.name
        holder.description.text = limitDescriptionToWords(flower.description, 10)
        holder.photo.setImageResource(flower.photo)

        holder.itemView.setOnClickListener {
            val intent = Intent(holder.itemView.context, DetailActivity::class.java).apply {
                putExtra("name", flower.name)
                putExtra("description", flower.description)
                putExtra("photo", flower.photo)
                putExtra("season", flower.season)
                putExtra("origin", flower.origin)
                putExtra("latin", flower.latin)
                putExtra("symbol", flower.symbol)

            }
            holder.itemView.context.startActivity(intent)
        }
    }

    private fun limitDescriptionToWords(description: String, wordLimit: Int): String {
        val words = description.split(" ")
        return if (words.size > wordLimit) {
            words.take(wordLimit).joinToString(" ") + "..."
        } else {
            description
        }
    }

    override fun getItemCount(): Int = list.size
}
