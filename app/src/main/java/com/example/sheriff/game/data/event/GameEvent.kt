package com.example.sheriff.game.data.event

import com.example.sheriff.game.data.GameLeaveCause
import com.example.sheriff.game.data.player.Player

/**
 * Includes all possible types of game events
 */
sealed class GameEvent {

    /**
     * Used when player left the game
     * @param cause player game leave cause
     */
    data class PlayerLeave(
        val player: Player,
        val cause: GameLeaveCause
    ) : GameEvent()
}