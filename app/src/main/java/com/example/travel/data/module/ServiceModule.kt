package com.example.travel.data.module

import com.example.travel.data.repository.AccountServiceImpl
import com.example.travel.data.service.AccountService
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class ServiceModule {

    @Binds abstract fun provideAccountService(impl: AccountServiceImpl): AccountService
}