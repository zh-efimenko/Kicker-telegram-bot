package io.zensoft.telegrambot.dto

/**
 * @author Yauheni Efimenko
 */
data class PlayerDto(
        val id: Long,
        val email: String,
        val fullName: String,
        val iconPath: String?
)