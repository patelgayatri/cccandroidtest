package com.techand.sampleapp.data.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.techand.sampleapp.data.model.Estimate

@Dao
interface EstimateDao {

    @Query("SELECT * FROM estimate")
    fun getEstimate(): LiveData<Estimate>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertEstimate(estimate: Estimate)

}