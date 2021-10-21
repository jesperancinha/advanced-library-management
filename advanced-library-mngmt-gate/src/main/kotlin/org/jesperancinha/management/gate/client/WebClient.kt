package org.jesperancinha.management.gate.client

import org.jesperancinha.management.domain.Book
import org.springframework.stereotype.Component
import reactor.core.publisher.Mono

@Component
class WebClient {
    fun getBookViaReactiveServiceById(id: Long): Mono<Book> = Mono.just(Book(1,"REACTIVE_Test"))

    fun getBookViaJpaServiceById(id: Long): Mono<Book> = Mono.just(Book(1,"JPA_Test"))
}