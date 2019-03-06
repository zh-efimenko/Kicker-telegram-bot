package io.zensoft.telegrambot.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.client.RestTemplate

/**
 * @author Yauheni Efimenko
 */
@Configuration
class RestConfig {

    @Bean
    fun restTemplate(): RestTemplate = RestTemplate()

}