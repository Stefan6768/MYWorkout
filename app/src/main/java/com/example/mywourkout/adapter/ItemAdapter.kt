package com.example.mywourkout.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.ViewParent
import android.widget.ImageView
import android.widget.TextView
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.mywourkout.R
import com.example.mywourkout.data.model.Myworkout
import com.example.mywourkout.ui.FragmentEinsDirections
import com.google.android.material.card.MaterialCardView

class ItemAdapter(
  private val context: Context,
  private val dataset: List<Myworkout>
) : RecyclerView.Adapter<ItemAdapter.ItemViewholder>() {

  class ItemViewholder(val  view: View) : RecyclerView.ViewHolder(view) {
    val textView: TextView = view.findViewById(R.id.item_text)
    val imageView: ImageView = view.findViewById(R.id.item_image)
    val cardView: MaterialCardView = view.findViewById(R.id.item_cardView)
  }

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewholder {


    val adapterLayout = LayoutInflater.from(parent.context)
      .inflate(R.layout.list_item, parent, false)

    return ItemViewholder(adapterLayout)
  }

  override fun onBindViewHolder(holder: ItemViewholder, position: Int) {
    val item = dataset[position]
    holder.textView.text = context.resources.getString(item.stringResource)
    holder.imageView.setImageResource(item.imageResource)
    holder.cardView.setOnClickListener{
      holder.view.findNavController()
        .navigate(FragmentEinsDirections.actionFragmentEinsToFragmentZwei())
    }

  }

  override fun getItemCount(): Int {
    return dataset.size
  }

}