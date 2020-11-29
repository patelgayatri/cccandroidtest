package com.techand.sampleapp.di

import android.content.Context
import com.techand.sampleapp.data.AppDatabase
import com.techand.sampleapp.data.dao.EstimateDao
import com.techand.sampleapp.data.dao.PersonDao
import com.techand.sampleapp.data.dao.PersonEstimateDao
import com.techand.sampleapp.data.repository.EstimateRepository
import com.techand.sampleapp.data.repository.PersonEstimateRepository
import com.techand.sampleapp.data.repository.PersonRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
object AppModule {


    @Singleton
    @Provides
    fun provideDatabase(@ApplicationContext appContext: Context) =
        AppDatabase.getInstance(appContext)

    @Singleton
    @Provides
    fun providePersonDao(db: AppDatabase) = db.personDao()

    @Singleton
    @Provides
    fun provideEstimateDao(db: AppDatabase) = db.estimateDao()

    @Singleton
    @Provides
    fun providePersonEstimateDao(db: AppDatabase) = db.personAndEstimateDao()

    @Singleton
    @Provides
    fun providePersonRepository(
        localDataSource: PersonDao
    ) = PersonRepository(localDataSource)

    @Singleton
    @Provides
    fun provideEstimateRepository(
        localDataSource: EstimateDao
    ) = EstimateRepository(localDataSource)

    @Singleton
    @Provides
    fun providePersonEstimateRepository(
        localDataSource: PersonEstimateDao
    ) = PersonEstimateRepository(localDataSource)
}