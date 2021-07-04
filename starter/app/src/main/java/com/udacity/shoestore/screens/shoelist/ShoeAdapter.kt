package com.udacity.shoestore.screens.shoelist

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.udacity.shoestore.R
import com.udacity.shoestore.models.Shoe

class ShoeAdapter : RecyclerView.Adapter<ShoeAdapter.ViewHolder>() {

    var dataShoeList = listOf<Shoe>(Shoe("Adidas Neo", 8.5, "Adidas", "Description"),
        Shoe("Adidas Neo", 8.5, "Adidas", "Description"),
        Shoe("Adidas Neo", 8.5, "Adidas", "Description"),
        Shoe("Adidas Neo", 8.5, "Adidas", "Description"),
        Shoe("Adidas Neo", 8.5, "Adidas", "Description"))

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = dataShoeList[position]
        holder.bind(item)
    }

    override fun getItemCount() = dataShoeList.size

    class ViewHolder private constructor(itemView: View): RecyclerView.ViewHolder(itemView) {
        val shoeName: TextView = itemView.findViewById(R.id.shoe_name)
        val shoeSize: TextView = itemView.findViewById(R.id.shoe_size)
        val shoeCompany: TextView = itemView.findViewById(R.id.shoe_company)
        val shoeDescription: TextView = itemView.findViewById(R.id.shoe_description)

        fun bind(item: Shoe) {
            shoeName.text = item.name
            shoeSize.text = item.size.toString()
            shoeCompany.text = item.company
            shoeDescription.text = item.description
        }

        companion object {
            fun from(parent: ViewGroup): ViewHolder {
                val view = LayoutInflater.from(parent.context)
                    .inflate(R.layout.list_item_shoe, parent, false)
                return ViewHolder(view)
            }
        }
    }
}