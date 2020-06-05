package com.ritwik.hackerrank.network

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Entity(tableName = "category_table")
@Parcelize
data class Category(
    @PrimaryKey
    val category_name: String,
    @ColumnInfo(name = "category_description")
    val category_description: String,
    @ColumnInfo(name = "questions")
    val questions: List<Question>
) : Parcelable