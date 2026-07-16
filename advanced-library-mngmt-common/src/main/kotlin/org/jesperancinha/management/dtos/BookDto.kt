package org.jesperancinha.management.dtos

import com.fasterxml.jackson.annotation.JsonProperty

data class BookDto(
    @param:JsonProperty("id")
    val id: Long?,
    @param:JsonProperty("title")
    val title: String,
    @param:JsonProperty("source")
    val source: SourceType? = null
)