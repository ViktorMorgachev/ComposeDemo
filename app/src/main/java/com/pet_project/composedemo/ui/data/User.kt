package com.pet_project.composedemo.ui.data

import androidx.annotation.DrawableRes
import com.pet_project.composedemo.R

data class User(
    val name: String,
    @DrawableRes val photoID: Int = R.drawable.contact,
    val phoneNumber: String,
    val age: Int,
    val hobby: String? = null
)