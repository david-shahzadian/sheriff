package com.example.sheriff.game.data

import com.example.sheriff.game.data.player.Player

/**
 * Includes all possible types of player's game leave causes
 */
sealed class GameLeaveCause {

    /**
     * Used when the player left the game after night shooting
     */
    object NightShooting : GameLeaveCause()

    /**
     * Used when the player left the game after vote
     * @param votedPlayers players voted against the current one
     * May be null if the user couldn't fix voted players
     */
    data class Vote(
        val votedPlayers: List<Player>?
    )
}