package com.kamrulhasan.affirmationapp.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Affirmation(
    @StringRes val personName: Int,
    @StringRes val personId: Int,
    @StringRes val bloodGroup: Int,
    @DrawableRes val imageResourceId: Int)