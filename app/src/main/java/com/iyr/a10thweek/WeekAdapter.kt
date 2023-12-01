package com.iyr.a10thweek

import android.content.ClipData.Item
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.iyr.a10thweek.databinding.ItemCalendarBinding

class WeekAdapter(var week : ArrayList<String>): RecyclerView.Adapter<WeekAdapter.ViewHolder>() {
    inner class ViewHolder(val binding : ItemCalendarBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item : String) {
            binding.tv.text = item
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemCalendarBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return week.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(week[position])
    }
}