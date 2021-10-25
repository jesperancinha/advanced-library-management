package org.jesperancinha.management.reactive.repository

import org.jesperancinha.management.reactive.domain.Book
import org.springframework.data.repository.reactive.ReactiveCrudRepository
import reactor.core.publisher.Mono

/**
 * Created by jofisaes on 20/10/2021
 */
interface BookRepository : ReactiveCrudRepository<Book, Long> {
    fun findByTitle(name: String): Mono<Book>
}