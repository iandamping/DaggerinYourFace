package com.junemon.daggerin.presentation.di

import com.junemon.daggerin.presentation.di.module.LoadImageHelperModule
import com.junemon.daggerin.presentation.di.module.RecyclerHelperModule
import com.junemon.daggerin.presentation.interfaces.LoadImageHelper
import com.junemon.daggerin.presentation.util.classes.LoadImageHelperImpl
import com.junemon.daggerin.presentation.util.classes.RecyclerHelperImpl
import com.junemon.daggerin.presentation.util.interfaces.RecyclerHelper
import dagger.Binds
import dagger.Module

@Module(includes = [LoadImageHelperModule::class,RecyclerHelperModule::class])
class RepositoryPresentationModule