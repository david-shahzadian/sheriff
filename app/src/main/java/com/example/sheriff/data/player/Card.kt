package com.example.sheriff.data.player

import com.example.sheriff.R

/**
 * Includes all possible types of cards
 */
enum class Card(val displayNameRes: Int) {

    PEACEFUL(R.string.display_name_card_peaceful),
    MAFIA(R.string.display_name_card_mafia),
    MANIAC(R.string.display_name_card_peaceful)
}