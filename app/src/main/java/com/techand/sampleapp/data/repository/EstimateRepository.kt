package com.techand.sampleapp.data.repository

import com.techand.sampleapp.data.dao.EstimateDao
import com.techand.sampleapp.data.model.Estimate
import javax.inject.Inject

class EstimateRepository @Inject constructor(private val estimateDao: EstimateDao) {

    suspend fun insertEstimate(estimate: Estimate) {
        estimateDao.insertEstimate(estimate)
    }
}