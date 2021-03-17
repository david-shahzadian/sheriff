package com.example.sheriff.game.data.player

import com.example.sheriff.data.player.Card
import com.example.sheriff.data.player.PeacefulRole

sealed class PlayerSign {

    abstract val card: Card

    abstract val probability: Int

    open fun getDisplayNameRes(): Int = card.displayNameRes

    data class Common(
        override val card: Card,
        override val probability: Int
    ) : PlayerSign()

    data class RolePlayer(
        val role: PeacefulRole,
        override val probability: Int
    ) : PlayerSign() {

        override val card: Card = Card.PEACEFUL

        override fun getDisplayNameRes(): Int = role.displayNameRes
    }
}