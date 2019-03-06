import io.zensoft.telegrambot.service.PlayerService
import me.ruslanys.telegraff.core.dsl.handler
import me.ruslanys.telegraff.core.dto.request.MarkdownMessage
import me.ruslanys.telegraff.core.exception.ValidationException

handler("/stats") {

    val stepPlayerId = "playerId"


    step<Long>(stepPlayerId) {
        question {
            MarkdownMessage("Введи *id* игрока!")
        }

        validation {
            try {
                Math.abs(it.toLong())
            } catch (e: Exception) {
                throw ValidationException("Укажи число")
            }
        }
    }

    process { _, answers ->
        val playerId = answers[stepPlayerId] as Long
        val playerService = getBean<PlayerService>()

        val playerStats = playerService.getPlayerStats(playerId)
                ?: return@process MarkdownMessage("Игрок с таким id не найден")

        val response = """
            _${playerStats.player.fullName}_:
            Rating: *${playerStats.rating}*
            Games played: *${playerStats.countGames}*
            Games rated: *${playerStats.rated}*
            Games won: *${playerStats.countWins}*
            Games lost: *${playerStats.countLosses}*
            Goals for: *${playerStats.goalsFor}*
            Goals against: *${playerStats.goalsAgainst}*
            Current loss streak: *${playerStats.currentLossesStreak}*
            Longest loss streak: *${playerStats.longestLossesStreak}*
            Current win streak: *${playerStats.currentWinningStreak}*
            Longest win streak: *${playerStats.longestWinningStreak}*
        """.trimIndent()

        MarkdownMessage(response)
    }

}