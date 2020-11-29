package com.techand.sampleapp.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "estimate")
data class Estimate(
    val address: String,
    val company: String,
    val contact: String,
    val created_by: String,
    val created_date: String,
    @PrimaryKey(autoGenerate = false)
    val id: String,
    val number: Int,
    val requested_by: String,
    val revision_number: Int
)