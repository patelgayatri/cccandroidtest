package com.techand.sampleapp.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "person")
data class Person(
    val email: String,
    val first_name: String,
    @PrimaryKey(autoGenerate = false)
    val id: String,
    val last_name: String,
    val phone_number: String
)