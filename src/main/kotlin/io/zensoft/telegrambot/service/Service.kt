package io.zensoft.telegrambot.service

import io.zensoft.telegrambot.domain.PlayerDto
import io.zensoft.telegrambot.domain.PlayerStatsDto
import io.zensoft.telegrambot.domain.PlayersDashboard

/**
 * @author Yauheni Efimenko
 */
interface PlayerService {

    fun getPlayerStats(playerId: Long): PlayerStatsDto?

    fun getPlayers(offset: Long, limit: Long): List<PlayerDto>

    fun getActivePlayers(offset: Long, limit: Long): List<PlayerStatsDto>

    fun getDashboard(): PlayersDashboard?

}