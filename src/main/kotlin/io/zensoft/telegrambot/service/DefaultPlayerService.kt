package io.zensoft.telegrambot.service

import io.zensoft.telegrambot.domain.PageResponse
import io.zensoft.telegrambot.domain.PlayerDto
import io.zensoft.telegrambot.domain.PlayerStatsDto
import io.zensoft.telegrambot.domain.PlayersDashboard
import org.springframework.core.ParameterizedTypeReference
import org.springframework.http.HttpMethod
import org.springframework.stereotype.Service
import org.springframework.web.client.RestTemplate

/**
 * @author Yauheni Efimenko
 */
@Service
class DefaultPlayerService(
        private val restTemplate: RestTemplate
) : PlayerService {

    override fun getPlayerStats(playerId: Long): PlayerStatsDto? {
        val path = String.format(PLAYER_STATS_PATH_TEMPLATE, playerId)

        return try {
            restTemplate.getForObject(path, PlayerStatsDto::class.java)
        } catch (e: Exception) {
            null
        }
    }

    override fun getPlayers(offset: Long, limit: Long): List<PlayerDto> {
        val path = String.format(PLAYERS_PATH_TEMPLATE, offset, limit)

        return try {
            val response = restTemplate.exchange(path, HttpMethod.GET, null,
                    object : ParameterizedTypeReference<PageResponse<PlayerDto>>() {})
            response.body!!.list
        } catch (e: Exception) {
            listOf()
        }
    }

    override fun getActivePlayers(offset: Long, limit: Long): List<PlayerStatsDto> {
        val path = String.format(ACTIVE_PLAYERS_PATH_TEMPLATE, offset, limit)

        return try {
            val response = restTemplate.exchange(path, HttpMethod.GET, null,
                    object : ParameterizedTypeReference<PageResponse<PlayerStatsDto>>() {})
            response.body!!.list
        } catch (e: Exception) {
            listOf()
        }
    }

    override fun getDashboard(): PlayersDashboard? {
        val path = PLAYERS_DASHBOARD_PATH_TEMPLATE

        return try {
            restTemplate.getForObject(path, PlayersDashboard::class.java)
        } catch (e: Exception) {
            null
        }
    }


    companion object {
        private const val PLAYER_STATS_PATH_TEMPLATE = "/api/players/%s/stats"
        private const val PLAYERS_PATH_TEMPLATE = "/api/players?offset=%s&limit=%s"
        private const val ACTIVE_PLAYERS_PATH_TEMPLATE = "/api/players/active/stats?offset=%s&limit=%s" +
                "&sortBy=rating&sortDirection=DESC"
        private const val PLAYERS_DASHBOARD_PATH_TEMPLATE = "/api/players/dashboard"
    }

}
