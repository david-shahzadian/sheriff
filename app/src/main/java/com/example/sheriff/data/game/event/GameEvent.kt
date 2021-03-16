package com.example.sheriff.data.game.event

import com.example.sheriff.data.game.GameLeaveCause
import com.example.sheriff.data.game.player.Player

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