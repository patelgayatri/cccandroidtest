package com.techand.sampleapp.ui

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.techand.sampleapp.data.model.Estimate
import com.techand.sampleapp.data.model.Person
import com.techand.sampleapp.data.model.PersonAndEstimate
import com.techand.sampleapp.data.repository.EstimateRepository
import com.techand.sampleapp.data.repository.PersonEstimateRepository
import com.techand.sampleapp.data.repository.PersonRepository
import io.reactivex.Flowable
import kotlinx.coroutines.launch

class MainViewModel @ViewModelInject constructor(
    private val personRepository: PersonRepository,
    private val estimateRepository: EstimateRepository,
    private val personEstimateRepository: PersonEstimateRepository
) : ViewModel() {

    init {
        initialDefaultPerson()
        initialDefaultEstimate()
    }

     val personEstimateLiveData: Flowable<List<PersonAndEstimate>> =
        personEstimateRepository.getPersonAndEstimate()


    private fun initialDefaultPerson() {
        val person = Person(
            "joseph.sham@fake.fake",
            "Joseph",
            "85a57f85-a52d-4137-a0d1-62e61362f716",
            "Sham",
            "123-456-7890"
        )
        viewModelScope.launch {
            personRepository.insertPerson(person)
        }
    }

    private fun initialDefaultEstimate() {
        val estimate = Estimate(
            "32 Commissioners Road East",
            "Placebo Secondary School",
            "85a57f85-a52d-4137-a0d1-62e61362f716",
            "85a57f85-a52d-4137-a0d1-62e61362f716",
            "2020-08-22 15:23:54",
            "c574b0b4-bdef-4b92-a8f0-608a86ccf5ab",
            32,
            "85a57f85-a52d-4137-a0d1-62e61362f716",
            3
        )
        viewModelScope.launch {
            estimateRepository.insertEstimate(estimate)
        }
    }
}
