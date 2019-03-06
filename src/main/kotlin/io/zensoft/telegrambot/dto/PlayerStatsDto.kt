package io.zensoft.telegrambot.dto

/**
 * @author Yauheni Efimenko
 */
data class PlayerStatsDto(
        val player: PlayerDto,
        val rating: Int,
        val currentWinningStreak: Int,
        val currentLossesStreak: Int,
        val longestWinningStreak: Int,
        val longestLossesStreak: Int,
        val countLosses: Int,
        val countWins: Int,
        val countGames: Int,
        val rated: Int,
        val winningPercentage: Double,
        val goalsAgainst: Int,
        val goalsFor: Int,
        val active: Boolean
)