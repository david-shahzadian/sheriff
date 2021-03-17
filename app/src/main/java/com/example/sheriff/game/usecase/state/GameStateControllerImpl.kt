package com.example.sheriff.game.usecase.state

import com.example.sheriff.game.data.event.GameEvent
import com.example.sheriff.game.data.player.Player
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