package com.example.sheriff.game.data.player

import com.example.sheriff.game.data.GameConfig
import com.example.sheriff.data.player.Card
import com.example.sheriff.data.player.PeacefulRole

object PlayerFactory {

    fun createDefaultPlayer(playerNumber: PlayerNumber, gameConfig: GameConfig): Player {
        return Player(
            playerNumber = playerNumber,
            signs = getDefaultSigns(gameConfig)
        )
    }

    private fun getDefaultSigns(gameConfig: GameConfig): List<PlayerSign> {
        return listOf(
            PlayerSign.Common(
                card = Card.PEACEFUL,
                probability = (gameConfig.calculatePeacefulPlayersCount() * 100) / gameConfig.playersCount
            ),
            PlayerSign.Common(
                card = Card.MAFIA,
                probability = (gameConfig.mafiaPlayersCount * 100) / gameConfig.playersCount
            ),
            PlayerSign.Common(
                card = Card.MANIAC,
                probability = 100 / gameConfig.playersCount
            )
        )
            .plus(
                PeacefulRole
                    .values()
                    .map { role ->
                        PlayerSign.RolePlayer(
                            role = role,
                            probability = (gameConfig.peacefulRoles.size * 100) / gameConfig.playersCount
                        )
                    }
            )
    }
}