package io.zensoft.telegrambot.domain

data class PlayersDashboard(
        val firstPlace: PlayerDto? = null,
        val secondPlace: PlayerDto? = null,
        val thirdPlace: PlayerDto? = null,
        val loser: PlayerDto? = null
)