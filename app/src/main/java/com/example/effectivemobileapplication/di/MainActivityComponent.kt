package com.example.effectivemobileapplication.di

import com.example.effectivemobileapplication.MainActivity
import dagger.Subcomponent

@Subcomponent
interface MainActivityComponent {


    @Subcomponent.Factory
    interface Factory {
        fun create(): MainActivityComponent
    }

    fun inject(activity: MainActivity)
}

interface MainActivityComponentProvider{
    fun providerMainActivityComponent():MainActivityComponent
}