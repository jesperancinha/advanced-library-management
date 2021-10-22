package org.jesperancinha.management.gate.client

import org.jesperancinha.management.domain.Book
import org.springframework.context.annotation.Profile
import org.springframework.stereotype.Component
import reactor.core.publisher.Mono

@Component
@Profile("prod")
class WebClient : WebClientInterface {
    override fun getBookViaReactiveServiceById(id: Long): Mono<Book> = Mono.just(Book(1, "REACTIVE_Test"))

    override fun getBookViaJpaServiceById(id: Long): Mono<Book> = Mono.just(Book(1, "JPA_Test"))
}