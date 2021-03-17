package com.example.sheriff.game.data.player

import com.example.sheriff.game.data.GameConfig
import com.example.sheriff.data.player.Card
import com.example.sheriff.data.player.PeacefulRole
import org.junit.Test

class PlayerFactoryTest {

    @Test
    fun `creates game config then creates player then checks mafia probability`() {
        val config = GameConfig(
            playersCount = 15,
            mafiaPlayersCount = 4,
            peacefulRoles = PeacefulRole.values().toList()
        )
        val player = PlayerFactory.createDefaultPlayer(1, config)
        assert(player.signs.any { it.card == Card.MAFIA && it.probability == config.mafiaPlayersCount * 100 / config.playersCount })
    }

    @Test
    fun `creates game config then creates player then checks maniac probability`() {
        val config = GameConfig(
            playersCount = 15,
            mafiaPlayersCount = 4,
            peacefulRoles = PeacefulRole.values().toList()
        )
        val player = PlayerFactory.createDefaultPlayer(1, config)
        assert(player.signs.any { it.card == Card.MANIAC && it.probability == 100 / config.playersCount })
    }

    @Test
    fun `creates game config then creates player then checks peaceful probability`() {
        val config = GameConfig(
            playersCount = 15,
            mafiaPlayersCount = 4,
            peacefulRoles = PeacefulRole.values().toList()
        )
        val player = PlayerFactory.createDefaultPlayer(1, config)
        assert(player.signs.any { it.card == Card.PEACEFUL && it.probability == config.calculatePeacefulPlayersCount() * 100 / config.playersCount })
    }

    @Test
    fun `creates game config then creates player then checks role probability`() {
        val config = GameConfig(
            playersCount = 15,
            mafiaPlayersCount = 4,
            peacefulRoles = PeacefulRole.values().toList()
        )
        val player = PlayerFactory.createDefaultPlayer(1, config)
        assert(player.signs.any { it is PlayerSign.RolePlayer && it.probability == config.peacefulRoles.size * 100 / config.playersCount })
    }
}