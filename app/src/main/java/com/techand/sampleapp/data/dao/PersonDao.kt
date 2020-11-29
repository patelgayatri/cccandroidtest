package com.techand.sampleapp.data.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.techand.sampleapp.data.model.Estimate
import com.techand.sampleapp.data.model.Person

@Dao
interface PersonDao {

    @Query("SELECT * FROM person")
    fun getPerson(): LiveData<Person>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertPerson(person: Person)

}