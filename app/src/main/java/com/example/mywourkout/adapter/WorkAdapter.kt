package com.example.mywourkout.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.myworkout.data.model.Workout
import com.example.mywourkout.R
import com.example.mywourkout.ui.FragmentEinsDirections
import com.google.android.material.card.MaterialCardView


class WorkAdapter(
  private val dataset: List<Workout>
) : RecyclerView.Adapter<WorkAdapter.ItemViewHolder>() {

  class ItemViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
    val textView: TextView = view.findViewById(R.id.item_text)
    val imageView: ImageView = view.findViewById(R.id.item_image)
    val cardView: MaterialCardView = view.findViewById(R.id.video_cardView)
  }

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {

    val adapterLayout = LayoutInflater.from(parent.context)
      .inflate(R.layout.list_item, parent, false)

    return ItemViewHolder(adapterLayout)
  }

  override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
    val item = dataset[position]
    holder.textView.text = item.string
    holder.imageView.setImageResource(item.imageResource)

    holder.cardView.setOnClickListener {
      holder.view.findNavController()
        .navigate(
          FragmentEinsDirections.actionFragmentEinsToFragmentZwei(
            item.string,
            item.imageResource
          )
        )
    }
  }

  override fun getItemCount(): Int {
    return dataset.size
  }


}