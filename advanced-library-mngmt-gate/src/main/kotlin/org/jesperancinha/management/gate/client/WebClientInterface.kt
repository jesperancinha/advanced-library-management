package org.jesperancinha.management.gate.client

import org.jesperancinha.management.domain.Book
import reactor.core.publisher.Mono

interface WebClientInterface {
    fun getBookViaReactiveServiceById(id: Long): Mono<Book>
    fun getBookViaJpaServiceById(id: Long): Mono<Book>
}
