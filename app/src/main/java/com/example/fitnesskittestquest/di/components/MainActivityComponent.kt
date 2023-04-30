package com.example.fitnesskittestquest.di.components

import com.example.fitnesskittestquest.di.AppComponent
import com.example.fitnesskittestquest.di.scopes.ScreenScope
import com.example.fitnesskittestquest.presentation.main_activity.MainActivity
import dagger.Component

@Component(dependencies = [AppComponent::class])
@ScreenScope
interface MainActivityComponent {

    @Component.Factory
    interface Factory {
        fun create(appComponent: AppComponent) : MainActivityComponent
    }

    fun inject(activity: MainActivity)

}