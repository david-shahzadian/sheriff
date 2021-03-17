package com.example.sheriff.game.usecase.state

import com.example.sheriff.game.data.event.GameEvent
import com.example.sheriff.game.data.player.Player
import kotlinx.coroutines.channels.ReceiveChannel

/**
 * Use to work with game state
 */
interface GameStateController : GameState, GameStateUpdater

/**
 * Provides read-only data about the game
 */
interface GameState {

    /**
     * Channel that emits game state snapshot when it's changed
     */
    val stateChangeChannel: ReceiveChannel<GameStateSnapshot>

    /**
     * @return players left at the table
     */
    fun getLeftPlayers(): List<Player>
}

/**
 * Use to update the game state
 */
interface GameStateUpdater {

    /**
     * Call when a game event happened
     * @param event happened game event
     */
    fun onEvent(event: GameEvent)
}