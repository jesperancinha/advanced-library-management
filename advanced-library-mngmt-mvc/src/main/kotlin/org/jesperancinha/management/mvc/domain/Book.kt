package org.jesperancinha.management.mvc.domain

import org.hibernate.Hibernate
import org.jesperancinha.management.domain.Book
import org.jesperancinha.management.dtos.SourceType
import java.util.Objects.hash
import javax.persistence.*
import javax.persistence.EnumType.STRING

/**
 * In JetBrains recommendations:
 * "The data class implementations of equals(), hashCode() and toString() are not recommended for JPA entities.
 * They can cause severe performance and memory consumption issues."
 */
@Table
@Entity
data class Book(
    @field: Id
    @field: GeneratedValue(strategy = GenerationType.AUTO)
    override val id: Long? = null,
    @field: Column
    override val title: String,
    @field: Column
    @field: Enumerated(STRING)
    override val source: SourceType
) : Book(id, title, source) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || Hibernate.getClass(this) != Hibernate.getClass(other)) return false
        other as Book

        return id != null && id == other.id
    }

    override fun hashCode(): Int = hash(id, title, source)

    @Override
    override fun toString(): String {
        return this::class.simpleName + "(id = $id , id = $id , title = $title , source = $source , title = $title , source = $source )"
    }
}
