package org.jesperancinha.management.reactive.domain

import org.jesperancinha.management.domain.Book
import org.jesperancinha.management.dtos.SourceType
import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Column

data class Book(
    @field: Id
    override val id: Long,
    @field: Column
    override val title: String,
    @field: Column
    override val source: SourceType
) : Book(id, title, source)
