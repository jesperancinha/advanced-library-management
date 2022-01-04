package org.jesperancinha.management.reactive.domain

import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import org.jesperancinha.management.domain.Book
import org.jesperancinha.management.dtos.SourceType
import org.springframework.data.annotation.Id
import org.springframework.data.domain.Persistable
import org.springframework.data.relational.core.mapping.Column
import java.time.LocalDateTime
import java.time.ZoneOffset.UTC


data class Book(
    @field: Id
    @field: GeneratedValue(strategy = GenerationType.AUTO)
    override val id: Long? = null,
    @field: Column
    override val title: String,
    @field: Column
    override val source: SourceType,
    @field: Column
    override val timestamp: Long = LocalDateTime.now().toEpochSecond(UTC),
    @field: Column
    override var newField: Boolean? = false
) : Persistable<Int>, Book(id, title, source, timestamp, newField) {

    override fun getId(): Int? {
        return id?.toInt()
    }

    override fun isNew(): Boolean = newField ?: false
}