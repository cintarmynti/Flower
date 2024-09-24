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
        var name: TextView = itemView.findViewById(R.id.tv_flower_name)  // ID harus sesuai dengan layout item
        var description: TextView = itemView.findViewById(R.id.tv_flower_description)  // ID harus sesuai dengan layout item
        var photo: ImageView = itemView.findViewById(R.id.img_flower)  // ID harus sesuai dengan layout item
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_flower, parent, false)
        return ListViewHolder(view)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val flower = list[position]
        holder.name.text = flower.name
        holder.description.text = flower.description
        holder.photo.setImageResource(flower.photo)

        holder.itemView.setOnClickListener {
            val intent = Intent(holder.itemView.context, DetailActivity::class.java).apply {
                putExtra("name", flower.name)
                putExtra("description", flower.description)
                putExtra("photo", flower.photo)
            }
            holder.itemView.context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int = list.size
}
