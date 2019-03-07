import me.ruslanys.telegraff.core.dsl.handler
import me.ruslanys.telegraff.core.dto.request.MarkdownMessage

handler("/help") {

    process { _, _ ->
        val message = """
            /help - _Получить список команд_
            /stats - _Получить статистику об игроке_
        """.trimIndent()

        MarkdownMessage(message)
    }

}