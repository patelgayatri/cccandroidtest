package com.techand.sampleapp.data.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Query
import androidx.room.Transaction
import com.techand.sampleapp.data.model.PersonAndEstimate
import io.reactivex.Flowable

@Dao
interface PersonEstimateDao {

    @Transaction
    @Query("select * from person")
    fun getPersonAndEstimate(): Flowable<List<PersonAndEstimate>>
}