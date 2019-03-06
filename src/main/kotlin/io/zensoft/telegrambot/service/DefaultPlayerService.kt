package io.zensoft.telegrambot.service

import io.zensoft.telegrambot.config.property.KickerApiProperties
import io.zensoft.telegrambot.dto.PlayerStatsDto
import org.springframework.stereotype.Service
import org.springframework.web.client.RestTemplate

/**
 * @author Yauheni Efimenko
 */
@Service
class DefaultPlayerService(
        private val restTemplate: RestTemplate,
        private val kickerApiProperties: KickerApiProperties
) : PlayerService {

    override fun getPlayerStats(playerId: Long): PlayerStatsDto? {
        val path = String.format(PLAYER_STATS_PATH_TEMPLATE, playerId)
        val uri = kickerApiProperties.host + path

        return try {
            restTemplate.getForObject(uri, PlayerStatsDto::class.java)
        } catch (e: Exception) {
            null
        }
    }


    companion object {
        private const val PLAYER_STATS_PATH_TEMPLATE = "/api/players/%s/stats"
    }

}
