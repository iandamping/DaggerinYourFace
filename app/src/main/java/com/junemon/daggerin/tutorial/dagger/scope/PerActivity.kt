package com.junemon.daggerin.tutorial.dagger.scope

import java.lang.annotation.Documented
import java.lang.annotation.Retention
import java.lang.annotation.RetentionPolicy
import javax.inject.Scope

@Scope
@Documented
@Retention(RetentionPolicy.RUNTIME)
annotation class PerActivity {
    /*We use this if we want to use this to create a singleton that only live with activity lifecycle*/

}