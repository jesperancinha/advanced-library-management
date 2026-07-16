package org.jesperancinha.management.mvc.repository

import org.jesperancinha.management.mvc.domain.Book
import org.springframework.data.jpa.repository.JpaRepository

interface BookRepository : JpaRepository<Book, Long> {
    fun findByTitle(name: String): Book
}

fun <T, ID> JpaRepository<T, ID>.findOne(id: ID): T? = findById(id).orElse(null)
