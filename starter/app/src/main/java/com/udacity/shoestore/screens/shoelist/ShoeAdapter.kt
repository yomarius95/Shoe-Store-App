package com.udacity.shoestore.screens.shoelist

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.udacity.shoestore.R
import com.udacity.shoestore.models.Shoe

class ShoeAdapter : ListAdapter<Shoe, ShoeAdapter.ViewHolder>(ShoeDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item)
    }

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

    class ShoeDiffCallback : DiffUtil.ItemCallback<Shoe>() {
        override fun areItemsTheSame(oldItem: Shoe, newItem: Shoe): Boolean {
            return oldItem.shoeId == newItem.shoeId
        }

        override fun areContentsTheSame(oldItem: Shoe, newItem: Shoe): Boolean {
            return oldItem == newItem
        }
    }
}