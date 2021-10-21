package org.jesperancinha.management.reactive.domain

import org.jesperancinha.management.domain.Book
import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Column

data class Book(
    @field: Id
    override val id: Long,
    @field: Column
    override val name: String
) : Book(id, name)