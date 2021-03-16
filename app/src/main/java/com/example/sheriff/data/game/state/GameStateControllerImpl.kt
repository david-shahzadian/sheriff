package com.example.sheriff.data.game.state

import com.example.sheriff.data.game.event.GameEvent
import com.example.sheriff.data.game.player.Player
import kotlinx.coroutines.channels.Channel

class GameStateControllerImpl : GameStateController {

    override val stateChangeChannel: Channel<GameStateSnapshot> = Channel()

    override fun getLeftPlayers(): List<Player> {
        TODO("Not yet implemented")
    }

    override fun onEvent(event: GameEvent) {
        TODO("Not yet implemented")
    }
}