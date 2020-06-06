package com.ritwik.hackerrank.network

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Question(
    val question_text: String,
    val question_link: String
) : Parcelable

