package com.techand.sampleapp.data.repository

import com.techand.sampleapp.data.dao.PersonEstimateDao
import com.techand.sampleapp.data.model.PersonAndEstimate
import javax.inject.Inject

class PersonEstimateRepository @Inject constructor(private val personEstimateDao: PersonEstimateDao) {

    suspend fun getPersonAndEstimate(): PersonAndEstimate {
        return personEstimateDao.getPersonAndEstimate()
    }
}