package org.jesperancinha.management.dtos

import com.fasterxml.jackson.annotation.JsonProperty

/**
 * Created by jofisaes on 20/10/2021
 */
data class BookDto(
    @JsonProperty("id")
    val id: Long?,
    @JsonProperty("title")
    val title: String,
    @JsonProperty("source")
    val source: SourceType? = null
)