import me.ruslanys.telegraff.core.dsl.handler
import me.ruslanys.telegraff.core.dto.request.MarkdownMessage

handler("/help") {

    process { _, _ ->
        val message = """
            /help - _Получить список команд_
            /stats - _Получить статистику об игроке_
            /players - _Получить список всех игроков_
            /active\_players - _Получить список активных игроков_
            /dashboard - _Получить дашборд игроков_
        """.trimIndent()

        MarkdownMessage(message)
    }

}