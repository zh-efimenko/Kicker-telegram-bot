package io.zensoft.telegrambot.service

import io.zensoft.telegrambot.dto.PlayerStatsDto

/**
 * @author Yauheni Efimenko
 */
interface PlayerService {

    fun getPlayerStats(playerId: Long): PlayerStatsDto?

}