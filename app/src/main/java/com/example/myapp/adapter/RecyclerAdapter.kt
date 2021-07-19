package com.example.myapp.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.myapp.R
import com.example.myapp.dataclasses.CardItem

class RecyclerAdapter: RecyclerView.Adapter<RecyclerAdapter.ViewHolder>() {

    val cardItem: CardItem = CardItem(
        arrayListOf(
            "Food", "Clothes", "Car", "Laptop", "Phone",
            "Other", "Desktop", "Trip", "Booking", "Tools", "Rent", "Delivery"),
        arrayListOf(
            R.drawable.ic_diet, R.drawable.ic_clothes, R.drawable.ic_car,
            R.drawable.ic_laptop, R.drawable.ic_phone, R.drawable.ic_other,
            R.drawable.ic_desktop, R.drawable.ic_trip, R.drawable.ic_hotel,
            R.drawable.ic_repair_tools, R.drawable.ic_rent, R.drawable.ic_delivery_truck))

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerAdapter.ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.cardveiw_item_category, parent, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: RecyclerAdapter.ViewHolder, position: Int) {
        holder.itemTextView.text = cardItem.titles[position]
        cardItem.images[position]?.let { holder.itemImageView.setImageResource(it) }
    }

    override fun getItemCount(): Int {
        return cardItem.titles.size
    }

    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        var itemImageButton: ImageButton
        var itemImageView: ImageView
        var itemTextView: TextView
        var itemImageFvButton: ImageButton

        init {
            itemImageButton = itemView.findViewById(R.id.catalog_button_id)
            itemImageView = itemView.findViewById(R.id.catalog_image_id)
            itemTextView = itemView.findViewById(R.id.catalog_title_id)
            itemImageFvButton = itemView.findViewById(R.id.fv_btn_id)

            itemImageButton.setOnClickListener {
                val position: Int = adapterPosition
                Toast.makeText(itemView.context, "clicked on ${cardItem.titles[position]}", Toast.LENGTH_SHORT).show()
            }

            itemImageFvButton.setOnClickListener {
                val position: Int = adapterPosition
                it.isSelected = !it.isSelected
                when(it.isSelected) {
                    true -> Toast.makeText(itemView.context, "favorite is ${cardItem.titles[position]}", Toast.LENGTH_SHORT).show()
                    false -> Toast.makeText(itemView.context, "favorite is not ${cardItem.titles[position]}", Toast.LENGTH_SHORT).show()
                }
            }

        }

    }
}