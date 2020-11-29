package com.techand.sampleapp.data.repository

import androidx.lifecycle.LiveData
import com.techand.sampleapp.data.dao.PersonEstimateDao
import com.techand.sampleapp.data.model.Person
import com.techand.sampleapp.data.model.PersonAndEstimate
import io.reactivex.Flowable
import javax.inject.Inject

class PersonEstimateRepository @Inject constructor(private val personEstimateDao: PersonEstimateDao) {

    fun getPersonAndEstimate(): Flowable<List<PersonAndEstimate>> {
        return personEstimateDao.getPersonAndEstimate()
    }
}