package com.techand.sampleapp.data.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.techand.sampleapp.data.model.Person

@Dao
interface PersonDao {


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertPerson(person: Person)


}