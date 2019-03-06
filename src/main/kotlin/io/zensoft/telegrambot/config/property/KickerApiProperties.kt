package io.zensoft.telegrambot.config.property

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.stereotype.Component
import org.springframework.validation.annotation.Validated
import javax.validation.constraints.NotBlank

/**
 * @author Yauheni Efimenko
 */
@ConfigurationProperties(prefix = "kicker.api")
@Validated
@Component
class KickerApiProperties(

        @field:NotBlank var host: String? = null

)