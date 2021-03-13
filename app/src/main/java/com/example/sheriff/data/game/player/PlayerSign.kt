package com.example.sheriff.data.game.player

import com.example.sheriff.data.player.Card
import com.example.sheriff.data.player.PeacefulRole

/**
 * Includes all possible types of player signs that can be bound to a player
 */
sealed class PlayerSign {

    /**
     * Card type included in current sign
     */
    abstract val card: Card

    /**
     * Probability of current sign
     */
    abstract val probability: Int

    /**
     * @return name to display to user
     */
    open fun getDisplayNameRes(): Int = card.displayNameRes

    /**
     * Common sign such peaceful, mafia or maniac
     * @param card of current sign
     * @param probability probability of current sign
     */
    data class Common(
        override val card: Card,
        override val probability: Int
    ) : PlayerSign()

    /**
     * Role players sign such as sheriff, kamikaze, doctor etc
     * @param role role of current sign
     * @param probability probability of current sign
     */
    data class RolePlayer(
        val role: PeacefulRole,
        override val probability: Int
    ) : PlayerSign() {

        override val card: Card = Card.PEACEFUL

        override fun getDisplayNameRes(): Int = role.displayNameRes
    }
}