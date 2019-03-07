import io.zensoft.telegrambot.service.PlayerService
import me.ruslanys.telegraff.core.dsl.handler
import me.ruslanys.telegraff.core.dto.request.MarkdownMessage

handler("/dashboard") {

    process { _, _ ->
        val playerService = getBean<PlayerService>()

        val dashboard = playerService.getDashboard()
                ?: return@process MarkdownMessage("Дашборд не найден")

        val response = """
            firstPlace: *${dashboard.firstPlace?.fullName}*
            secondPlace: *${dashboard.secondPlace?.fullName}*
            thirdPlace: *${dashboard.thirdPlace?.fullName}*
            loser: *${dashboard.loser?.fullName}*
        """.trimIndent()

        MarkdownMessage(response)
    }

}