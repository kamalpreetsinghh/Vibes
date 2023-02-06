package com.cleverlycode.vibes.data.service.module

import com.cleverlycode.vibes.data.service.AccountService
import com.cleverlycode.vibes.data.service.ProfileService
import com.cleverlycode.vibes.data.service.impl.AccountServiceImpl
import com.cleverlycode.vibes.data.service.impl.ProfileServiceImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
abstract class ServiceModule {
    @Binds
    abstract fun provideAccountService(impl: AccountServiceImpl): AccountService

    @Binds
    abstract fun provideProfileService(impl: ProfileServiceImpl): ProfileService
}