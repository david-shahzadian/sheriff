package com.example.sheriff.game.di

import com.example.sheriff.game.usecase.state.GameStateController
import com.example.sheriff.game.usecase.state.GameStateControllerImpl
import dagger.Module
import dagger.Provides

@Module
object GameModule {

    @Provides
    fun provideGameStateController(): GameStateController {
        return GameStateControllerImpl()
    }
}