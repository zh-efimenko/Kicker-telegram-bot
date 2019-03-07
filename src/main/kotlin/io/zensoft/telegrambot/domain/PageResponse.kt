package io.zensoft.telegrambot.domain

/**
 * @author Yauheni Efimenko
 */
open class PageResponse<T>(val totalCount: Long, val list: List<T>)