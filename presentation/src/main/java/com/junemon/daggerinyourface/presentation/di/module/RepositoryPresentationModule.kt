package com.junemon.daggerinyourface.presentation.di.module

import com.junemon.daggerinyourface.presentation.di.module.LoadImageHelperModule
import com.junemon.daggerinyourface.presentation.di.module.RecyclerHelperModule
import dagger.Module

@Module(includes = [LoadImageHelperModule::class,RecyclerHelperModule::class,ViewModelModule::class])
class RepositoryPresentationModule