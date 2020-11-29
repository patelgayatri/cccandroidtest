package com.techand.sampleapp.data.repository

import com.techand.sampleapp.data.dao.PersonDao
import com.techand.sampleapp.data.model.Person
import javax.inject.Inject

class PersonRepository @Inject constructor(private val personDao: PersonDao) {

    suspend fun insertPerson(person: Person) {
        personDao.insertPerson(person)
    }

}