package com.udacity.shoestore.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Shoe(
    var shoeId: Int, var name: String, var size: Double, var company: String, var description: String,
    val images: List<String> = mutableListOf()) : Parcelable {
    constructor(): this(0, "", 0.0, "", "")
}