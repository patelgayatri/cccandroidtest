package com.techand.sampleapp.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.techand.sampleapp.data.dao.EstimateDao
import com.techand.sampleapp.data.dao.PersonDao
import com.techand.sampleapp.data.dao.PersonEstimateDao
import com.techand.sampleapp.data.model.Estimate
import com.techand.sampleapp.data.model.Person
import com.techand.sampleapp.data.model.PersonAndEstimate


@Database(entities = [Person::class, Estimate::class],version = 1, exportSchema = false)
abstract class AppDatabase: RoomDatabase() {
    abstract fun personDao(): PersonDao
    abstract fun estimateDao(): EstimateDao
    abstract fun personAndEstimateDao(): PersonEstimateDao

    companion object {
        @Volatile
        private var instance: AppDatabase? = null

        fun getInstance(context: Context): AppDatabase =
            instance ?: synchronized(this){
                instance
                    ?: buildDatabase(context)
                        .also {
                            instance = it
                        }
            }
        private fun buildDatabase(context: Context) =
            Room.databaseBuilder(
                context.applicationContext,
                AppDatabase::class.java,
                "HoursTracking.db"
            )
                .allowMainThreadQueries()
                .build()
    }
}