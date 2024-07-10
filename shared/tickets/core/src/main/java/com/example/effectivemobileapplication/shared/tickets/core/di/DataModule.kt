package com.example.effectivemobileapplication.shared.tickets.core.di

import com.example.effectivemobileapplication.shared.tickets.core.data.network.ApiFactory
import com.example.effectivemobileapplication.shared.tickets.core.data.network.ApiService
import com.example.effectivemobileapplication.shared.tickets.core.data.repository.TicketsRepositoryImpl
import com.example.effectivemobileapplication.shared.tickets.core.domain.repository.TicketsRepository
import dagger.Binds
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
interface DataModule {
    @Singleton
    @Binds
    fun bindRepository(impl: TicketsRepositoryImpl): TicketsRepository

    companion object {
        @Singleton
        @Provides
        fun provideApiService(): ApiService {
            return ApiFactory.apiService
        }
    }
}