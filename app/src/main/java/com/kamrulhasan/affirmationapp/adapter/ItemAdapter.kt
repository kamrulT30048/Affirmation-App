package com.kamrulhasan.affirmationapp.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.kamrulhasan.affirmationapp.R
import com.kamrulhasan.affirmationapp.model.Affirmation

class ItemAdapter(private val context: Context,
                  private val dataset: List<Affirmation>)
    : RecyclerView.Adapter<ItemAdapter.ItemViewHolder>(){

    class ItemViewHolder(private val view: View)
        : RecyclerView.ViewHolder(view){
        val textView: TextView = view.findViewById(R.id.tv_item_title)
        val textViewSerial: TextView = view.findViewById(R.id.tv_serial)
//        val cardLayout: LinearLayout = view.findViewById(R.id.ll_card)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int)
    : ItemViewHolder {
        // create a new view
        val adapterLayout = LayoutInflater.from(parent.context)
            .inflate(R.layout.list_item, parent, false)
        return ItemViewHolder((adapterLayout))
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item = dataset[position]
        val serial = position+1
        holder.textView.text = context.resources.getString(item.stringResourceId)
        holder.textViewSerial.text = (serial).toString()
    }

    override fun getItemCount(): Int {
        return dataset.size
    }

}