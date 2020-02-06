package com.example.flashcards.ui.flashcard_review

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.flashcards.R
import com.example.flashcards.db.flashcard.Flashcard
import com.example.flashcards.ui.home.FlashcardsDiffUtil

class FlashcardReviewAdapter :
    ListAdapter<Flashcard, FlashcardSliderViewHolder>(FlashcardsDiffUtil()) {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): FlashcardSliderViewHolder {
        return FlashcardSliderViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.flashcard_review_base_layout,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: FlashcardSliderViewHolder, position: Int) {
        val flashcard = getItem(position)
        holder.bind(flashcard)
    }

}

class FlashcardSliderViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    private val textTitle = view.findViewById<TextView>(R.id.flashcard_review_title)
    private val textDescription =
        view.findViewById<TextView>(R.id.flashcard_review_description)

    fun bind(flashcard: Flashcard) {
        textTitle.text = flashcard.title
        textDescription.text = flashcard.description
    }
}

class FlashcardsDiffUtil : DiffUtil.ItemCallback<Flashcard>() {
    override fun areItemsTheSame(oldItem: Flashcard, newItem: Flashcard): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Flashcard, newItem: Flashcard): Boolean {
        return oldItem.id == newItem.id
    }
}

