package org.jesperancinha.management.reactive.repository

import org.jesperancinha.management.domain.Book
import org.springframework.data.r2dbc.repository.R2dbcRepository
import reactor.core.publisher.Mono

/**
 * Created by jofisaes on 20/10/2021
 */
interface BookRepository : R2dbcRepository<Book, Long> {
    fun findByName(name: String): Mono<Book>
}