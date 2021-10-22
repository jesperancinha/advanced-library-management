package org.jesperancinha.management.gate.client

import org.jesperancinha.management.domain.Book
import org.jesperancinha.management.gate.exception.ReactiveAccessException
import org.springframework.context.annotation.Profile
import org.springframework.stereotype.Component
import reactor.core.publisher.Mono
import java.time.Duration

@Component
@Profile("test")
class WebClientTest : WebClientInterface {
    override fun getBookViaReactiveServiceById(id: Long): Mono<Book> =
        listOf(
            Mono.error(ReactiveAccessException()),
            Mono.error(ReactiveAccessException()),
            Mono.error(ReactiveAccessException()),
            Mono.error(ReactiveAccessException()),
            Mono.just(Book(1, "REACTIVE_Test")),
            Mono.just(Book(1, "REACTIVE_Test")).delaySubscription(Duration.ofSeconds(1)),
            Mono.just(Book(1, "REACTIVE_Test"))
        ).random()


    override fun getBookViaJpaServiceById(id: Long): Mono<Book> = Mono.just(Book(1, "JPA_Test"))
}