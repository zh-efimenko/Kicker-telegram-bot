import io.zensoft.telegrambot.service.PlayerService
import me.ruslanys.telegraff.core.dsl.handler
import me.ruslanys.telegraff.core.dto.request.MarkdownMessage
import me.ruslanys.telegraff.core.exception.ValidationException
import java.util.*

handler("/players") {

    val stepOffset = "offset"
    val stepLimit = "limit"


    step<Long>(stepOffset) {
        question {
            MarkdownMessage("Введи offset запроса")
        }

        validation {
            try {
                Math.abs(it.toLong())
            } catch (e: Exception) {
                throw ValidationException("Укажи число")
            }
        }
    }

    step<Long>(stepLimit) {
        question {
            MarkdownMessage("Введи limit запроса")
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
        val offset = answers[stepOffset] as Long
        val limit = answers[stepLimit] as Long
        val playerService = getBean<PlayerService>()

        val players = playerService.getPlayers(offset, limit)

        val response = StringJoiner("\n").setEmptyValue("Список пуст")
        players.forEach { response.add("${it.fullName} - *id: ${it.id}*") }

        MarkdownMessage(response.toString())
    }

}