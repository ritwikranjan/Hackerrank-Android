package com.ritwik.hackerrank.network

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import kotlinx.android.parcel.Parcelize

@Entity(tableName = "questions_table")
@Parcelize
data class Question(
    @ColumnInfo(name = "")
    val question_text: String,
    val question_link: String
) : Parcelable

