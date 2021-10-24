package org.jesperancinha.management.mvc.domain

import org.jesperancinha.management.domain.Book
import org.springframework.data.annotation.Id
import javax.persistence.Column

data class Book(
    @field: Id
    override val id: Long,
    @field: Column
    override val title: String
) : Book(id, title)