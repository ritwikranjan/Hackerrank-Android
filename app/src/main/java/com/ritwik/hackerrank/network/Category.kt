package com.ritwik.hackerrank.network

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Category(
    val category_name: String,
    val category_description: String,
    val questions: List<Question>
) : Parcelable