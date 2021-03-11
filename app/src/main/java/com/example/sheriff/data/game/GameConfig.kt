package com.example.sheriff.data.game

import com.example.sheriff.data.player.PeacefulRole

data class GameConfig(
    val playersCount: Int,
    val mafiaPlayersCount: Int,
    val peacefulRoles: List<PeacefulRole>
) {

    fun calculatePeacefulPlayersCount(): Int =
        playersCount - mafiaPlayersCount - 1 - peacefulRoles.size
}