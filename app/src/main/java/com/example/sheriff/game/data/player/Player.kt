package com.example.sheriff.game.data.player

/**
 * Includes info about a current player
 * @param playerNumber number of the player at the table
 * @param signs signs that are bound to the player
 */
data class Player(
    val playerNumber: PlayerNumber,
    val signs: List<PlayerSign>
)