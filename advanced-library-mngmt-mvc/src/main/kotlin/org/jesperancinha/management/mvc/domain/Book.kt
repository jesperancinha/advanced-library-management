package org.jesperancinha.management.mvc.domain

import org.hibernate.Hibernate
import org.jesperancinha.management.domain.Book
import java.util.*
import java.util.Objects.hash
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

/**
 * In JetBrains recommendations:
 * "The data class implementations of equals(), hashCode() and toString() are not recommended for JPA entities.
 * They can cause severe performance and memory consumption issues."
 */
@Table
@Entity
data class Book(
    @field: Id
    override val id: Long,
    @field: Column
    override val title: String
) : Book(id, title) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || Hibernate.getClass(this) != Hibernate.getClass(other)) return false
        other as Book

        return id == other.id
    }

    override fun hashCode(): Int = hash(id, title)

    @Override
    override fun toString(): String {
        return this::class.simpleName + "(id = $id , title = $title )"
    }
}
