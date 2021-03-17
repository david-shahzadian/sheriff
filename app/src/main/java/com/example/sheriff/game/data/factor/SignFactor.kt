package com.example.sheriff.game.data.factor

import com.example.sheriff.game.data.Emotion
import com.example.sheriff.game.data.GameLeaveCause
import com.example.sheriff.game.data.SheriffCheckResult
import com.example.sheriff.game.data.player.Player
import com.example.sheriff.data.player.PeacefulRole

/**
 * Includes factors that can affect player sign
 */
sealed class SignFactor {

    /**
     * Used when the player is check by the sheriff
     * @param checker player that has announced himself a sheriff and checked the player
     * May be null if the sheriff is unknown
     * @param result result of the sheriffs check
     */
    data class CheckedBySheriff(
        val checker: Player?,
        val result: SheriffCheckResult
    ) : SignFactor()

    /**
     * Used when the player is healed by doctor
     * @param doctor player that has announced himself a doctor and healed the player
     * May be null if the doctor is unknown
     */
    data class SavedByDoctor(
        val doctor: Player?
    ) : SignFactor()

    /**
     * Used when the emotion of the player is changed
     * @param emotion new emotion
     */
    data class EmotionChange(
        val emotion: Emotion
    ) : SignFactor()

    /**
     * Used when the player trusts in another one
     * @param trustedPlayer another player that is trusted by the current one
     */
    data class TrustInAPlayer(
        val trustedPlayer: Player
    ) : SignFactor()

    /**
     * Used when the player is trusted by another one
     * @param player another player that trusts in the current one
     */
    data class TrustByAnotherPlayer(
        val player: Player
    ) : SignFactor()

    /**
     * Used when the player announces himself a player with a role
     * @param role announced role
     * May be null if the player announced himself a player with a role
     * without saying what role he has
     * @param otherIdenticalAnnouncedRoles players that has announced themselves
     * the identical role
     */
    data class RoleAnnouncement(
        val role: PeacefulRole?,
        val otherIdenticalAnnouncedRoles: List<Player>
    ) : SignFactor()

    /**
     * Used when the player left the game
     * @param cause cause of game leaving
     */
    data class GameLeave(
        val cause: GameLeaveCause
    ) : SignFactor()
}