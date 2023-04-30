package com.example.fitnesskittestquest.presentation.main_activity

import android.annotation.SuppressLint
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.graphics.drawable.toDrawable
import androidx.recyclerview.widget.RecyclerView
import com.example.fitnesskittestquest.R

class MainActivityRecyclerAdapter:
    RecyclerView.Adapter<MainActivityRecyclerAdapter.MyViewHolders>() {

    private val data = mutableListOf<BaseLessonPresentationModel>()

    sealed class MyViewHolders(
        itemView: View
    ): RecyclerView.ViewHolder(itemView) {

        class ViewHolderLesson(
            itemView: View
        ): MyViewHolders(itemView) {
            private val startTimeTextView: TextView = itemView.findViewById(R.id.startTimeTextView)
            private val endTimeTextView: TextView = itemView.findViewById(R.id.endTimeTextView)
            private val trainingNameTextView: TextView = itemView.findViewById(R.id.trainingNameTextView)
            private val trainerNameTextView: TextView = itemView.findViewById(R.id.trainerNameTextView)
            private val cardTypeColorImageView: ImageView = itemView.findViewById(R.id.cardTypeColorImageView)
            private val locationTextView: TextView = itemView.findViewById(R.id.locationTextView)

            fun setLessonsItems(item: BaseLessonPresentationModel.Item) {
                startTimeTextView.text = item.lesson.startTime
                endTimeTextView.text = item.lesson.endTime
                trainingNameTextView.text = item.lesson.name
                trainerNameTextView.text = item.lesson.coachId
                locationTextView.text = item.lesson.place
                cardTypeColorImageView.background = Color.parseColor(item.lesson.color).toDrawable()
            }
        }

        class ViewHolderDate(
            itemView: View
        ): MyViewHolders(itemView) {
            private val dateItemTextView: TextView = itemView.findViewById(R.id.dateItemTextView)

            fun setDatesItems(date: BaseLessonPresentationModel.Date) {
                dateItemTextView.text = date.date
            }
        }
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setData(list: List<BaseLessonPresentationModel>) {
        data.clear()
        data.addAll(list)
        notifyDataSetChanged()
    }

    override fun getItemViewType(position: Int): Int {
        return when (data[position]) {
            is BaseLessonPresentationModel.Item -> {
                0
            }
            is BaseLessonPresentationModel.Date -> {
                1
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolders {
        return when (viewType) {
            0 -> {
                val itemView = LayoutInflater.from(parent.context).inflate(R.layout.recycler_view_item, parent, false)
                MyViewHolders.ViewHolderLesson(itemView)
            }
            1 -> {
                val itemView = LayoutInflater.from(parent.context).inflate(R.layout.recycler_view_date_item, parent, false)
                MyViewHolders.ViewHolderDate(itemView)
            }
            else -> error("")
        }
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: MyViewHolders, position: Int) {
        when (holder) {
            is MyViewHolders.ViewHolderLesson -> {
                holder.setLessonsItems(data[position] as BaseLessonPresentationModel.Item)
            }
            is MyViewHolders.ViewHolderDate -> {
                holder.setDatesItems(data[position] as BaseLessonPresentationModel.Date)
            }
        }
    }
}