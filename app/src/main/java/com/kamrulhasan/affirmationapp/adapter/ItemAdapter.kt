package com.kamrulhasan.affirmationapp.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.kamrulhasan.affirmationapp.R
import com.kamrulhasan.affirmationapp.model.Affirmation

class ItemAdapter(
    private val context: Context,
    private val dataset: List<Affirmation>
) : RecyclerView.Adapter<ItemAdapter.ItemViewHolder>() {

    class ItemViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {
        val personImage: ImageView = view.findViewById(R.id.iv_student_image)
        val personName: TextView = view.findViewById(R.id.tv_student_name)
        val personId: TextView = view.findViewById(R.id.tv_trainee_id)
        val personBloodGroup: TextView = view.findViewById(R.id.tv_blood_group)
//        val textView: TextView = view.findViewById(R.id.tv_item_title)
//        val textViewSerial: TextView = view.findViewById(R.id.tv_item_serial)
//        val imageView: ImageView = view.findViewById(R.id.iv_item_image)
//        val cardLayout: LinearLayout = view.findViewById(R.id.ll_card)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int)
            : ItemViewHolder {
        // create a new view
        val adapterLayout = LayoutInflater.from(parent.context)
            .inflate(R.layout.id_info_item, parent, false)
        return ItemViewHolder((adapterLayout))
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item = dataset[position]

        val name = "Name: " + context.resources.getString(item.personName)
        val id = "Id: " + context.resources.getString(item.personId)
        val bloodGroup = "Blood Group: " + context.resources.getString(item.bloodGroup)

        holder.personImage.setImageResource(item.imageResourceId)
        holder.personName.text = name
        holder.personId.text = id
        holder.personBloodGroup.text = bloodGroup
    }

    override fun getItemCount(): Int {
        return dataset.size
    }

}