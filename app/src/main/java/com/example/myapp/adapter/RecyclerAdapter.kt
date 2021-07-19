package com.example.myapp.adapter

import android.content.Context
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
import kotlinx.android.synthetic.main.cardveiw_item_category.view.*

class RecyclerAdapter(var arrayList: ArrayList<CardItem>):
    RecyclerView.Adapter<RecyclerAdapter.ViewHolder>() {

    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        var itemImageButton: ImageButton
        var itemImageFvButton: ImageButton

        fun bindItems(cardItem: CardItem) {
            itemView.catalog_title_id.text = cardItem.title
            itemView.catalog_image_id.setImageResource(cardItem.image)
        }

        init {
            itemImageButton = itemView.findViewById(R.id.catalog_button_id)
            itemImageFvButton = itemView.findViewById(R.id.fv_btn_id)

            itemImageButton.setOnClickListener {
                val position: Int = adapterPosition
                Toast.makeText(itemView.context, "clicked on ${arrayList[position].title}", Toast.LENGTH_SHORT).show()
            }

            itemImageFvButton.setOnClickListener {
                val position: Int = adapterPosition
                it.isSelected = !it.isSelected
                when(it.isSelected) {
                    true -> Toast.makeText(itemView.context, "favorite is ${arrayList[position].title}", Toast.LENGTH_SHORT).show()
                    false -> Toast.makeText(itemView.context, "favorite is not ${arrayList[position].title}", Toast.LENGTH_SHORT).show()
                }
            }

        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerAdapter.ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.cardveiw_item_category, parent, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: RecyclerAdapter.ViewHolder, position: Int) = holder.bindItems(arrayList[position])

    override fun getItemCount(): Int = arrayList.size
}