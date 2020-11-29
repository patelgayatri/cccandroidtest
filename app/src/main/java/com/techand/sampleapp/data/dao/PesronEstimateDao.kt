package com.techand.sampleapp.data.dao

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Transaction
import com.techand.sampleapp.data.model.PersonAndEstimate

@Dao
interface PersonEstimateDao {

    @Transaction
    @Query("select * from person")
    suspend fun getPersonAndEstimate(): PersonAndEstimate

}