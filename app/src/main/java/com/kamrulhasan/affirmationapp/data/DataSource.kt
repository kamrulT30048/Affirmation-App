package com.kamrulhasan.affirmationapp.data

import com.kamrulhasan.affirmationapp.R
import com.kamrulhasan.affirmationapp.model.Affirmation


class DataSource {
    fun loadAffirmation(): List<Affirmation> {
        return listOf(
            Affirmation(R.string.person1, R.string.id1, R.string.A_negative, R.drawable.image1),
            Affirmation(R.string.person2, R.string.id2, R.string.AB_positive, R.drawable.image2),
            Affirmation(R.string.person3, R.string.id3, R.string.B_positive, R.drawable.image3),
            Affirmation(R.string.person4, R.string.id4, R.string.A_positive, R.drawable.image4),
            Affirmation(R.string.person5, R.string.id5, R.string.O_negative, R.drawable.image5),
            Affirmation(R.string.person6, R.string.id6, R.string.B_positive, R.drawable.image6),
            Affirmation(R.string.person7, R.string.id7, R.string.AB_positive, R.drawable.image7),
            Affirmation(R.string.person8, R.string.id8, R.string.B_negative, R.drawable.image8),
            Affirmation(R.string.person9, R.string.id9, R.string.O_negative, R.drawable.image9),
            Affirmation(R.string.person10, R.string.id10, R.string.AB_negative, R.drawable.image10),
        )
    }


}