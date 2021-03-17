package com.example.sheriff.game.data

import com.example.sheriff.data.player.PeacefulRole

/**
 * Includes info about the game
 * @param playersCount total count of the players at the table
 * @param mafiaPlayersCount count of the players with mafia role
 * @param peacefulRoles count of the players with peaceful role
 */
data class GameConfig(
    val playersCount: Int,
    val mafiaPlayersCount: Int,
    val peacefulRoles: List<PeacefulRole>
) {

    /**
     * @return count of the players with role peaceful without any peaceful roles
     */
    fun calculatePeacefulPlayersCount(): Int =
        playersCount - mafiaPlayersCount - 1 - peacefulRoles.size
}