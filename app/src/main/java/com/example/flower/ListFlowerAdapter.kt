package com.example.flower

import Flower
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

// Adapter untuk List Flower
class ListFlowerAdapter(private val listFlower: ArrayList<Flower>) : RecyclerView.Adapter<ListFlowerAdapter.ListViewHolder>() {

    // ViewHolder untuk setiap item dalam RecyclerView
    class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imgPhoto: ImageView = itemView.findViewById(R.id.img_item_photo)
        val tvName: TextView = itemView.findViewById(R.id.tv_item_name)
        val tvDescription: TextView = itemView.findViewById(R.id.tv_item_description)
    }

    // Method untuk membuat tampilan ViewHolder
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_row_flower, parent, false)
        return ListViewHolder(view)
    }

    // Menghubungkan data ke ViewHolder
    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val (name, description, photo) = listFlower[position]
        holder.imgPhoto.setImageResource(photo)
        holder.tvName.text = name
        holder.tvDescription.text = description
    }

    // Menghitung jumlah item
    override fun getItemCount(): Int = listFlower.size
}
