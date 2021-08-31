package com.pet_project.composedemo.ui.data

import androidx.annotation.DrawableRes
import com.pet_project.composedemo.R

data class Contact(val name: String = "Name", val phone: String = "000000000", @DrawableRes val photoID: Int = R.drawable.contact)

fun Pair<Int, Pair<String, String>>.toContact(): Contact{
    return Contact(photoID = first, name = second.first, phone = second.second)
}