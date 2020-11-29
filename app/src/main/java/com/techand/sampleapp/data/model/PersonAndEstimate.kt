package com.techand.sampleapp.data.model

import androidx.room.Embedded
import androidx.room.Relation

data class PersonAndEstimate(
    @Embedded val person: Person,
    @Relation(parentColumn = "id", entityColumn = "created_by")
    val estimate: Estimate
)