package io.zensoft.telegrambot.config

import io.zensoft.telegrambot.config.property.KickerApiProperties
import org.springframework.boot.web.client.RestTemplateBuilder
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.client.RestTemplate

/**
 * @author Yauheni Efimenko
 */
@Configuration
class RestConfig(
        private val kickerApiProperties: KickerApiProperties
) {

    @Bean
    fun restTemplate(restTemplateBuilder: RestTemplateBuilder): RestTemplate =
            restTemplateBuilder.rootUri(kickerApiProperties.host).build()

}