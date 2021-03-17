package com.example.sheriff.game.di

import com.example.sheriff.game.usecase.state.GameStateController
import com.example.sheriff.game.usecase.state.GameStateControllerImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent

@Module
@InstallIn(ActivityComponent::class)
object GameModule {

    @Provides
    fun provideGameStateController(): GameStateController {
        return GameStateControllerImpl()
    }
}