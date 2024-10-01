package com.example.travel.data.module

import android.content.Context
import com.example.travel.data.manager.AuthPreferences
import com.example.travel.data.repository.AccountServiceImpl
import com.example.travel.data.service.AccountService
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class ServiceModule {

    @Binds abstract fun provideAccountService(impl: AccountServiceImpl): AccountService
}

