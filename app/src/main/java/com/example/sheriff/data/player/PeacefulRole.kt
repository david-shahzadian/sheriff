package com.example.sheriff.data.player

import com.example.sheriff.R

enum class PeacefulRole(val displayNameRes: Int) {

    SHERIFF(R.string.display_name_role_sheriff),
    DOCTOR(R.string.display_name_role_doctor),
    KAMIKAZE(R.string.display_name_role_kamikaze),
    TERRORIST(R.string.display_name_role_terrorist)
}