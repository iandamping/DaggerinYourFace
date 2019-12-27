package com.junemon.daggerinyourface.presentation.di.module

import dagger.Module

@Module(includes = [LoadImageHelperModule::class, RecyclerHelperModule::class, ViewModelModule::class])
class RepositoryPresentationModule
