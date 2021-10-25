package org.jesperancinha.management.gate.client

import org.jesperancinha.management.dtos.BookDto
import org.jesperancinha.management.gate.exception.NotConfiguredException
import org.jesperancinha.management.gate.exception.ReactiveAccessException
import org.springframework.context.annotation.Profile
import org.springframework.stereotype.Component
import reactor.core.publisher.Mono
import java.time.Duration

@Component
@Profile("test")
class WebClientTest : WebClientInterface {
    override fun getBookViaReactiveServiceById(id: Long): Mono<BookDto> =
        mockRandomResponse()

    override fun getBookViaJpaServiceById(id: Long): Mono<BookDto> = Mono.just(BookDto(1, "JPA_Test"))

    override fun sendBookViaReactiveService(bookDto: BookDto): Mono<BookDto> = mockRandomResponse()

    override fun sendViaJpaServiceBook(bookDto: BookDto): Mono<BookDto> = Mono.just(BookDto(1, "JPA_Test"))

    private fun mockRandomResponse() = listOf<Mono<BookDto>>(
        Mono.error(ReactiveAccessException()),
        Mono.error(ReactiveAccessException()),
        Mono.error(ReactiveAccessException()),
        Mono.error(ReactiveAccessException()),
        Mono.error(NotConfiguredException()),
        Mono.just(BookDto(1, "REACTIVE_Test")),
        Mono.just(BookDto(1, "REACTIVE_Test")).delaySubscription(Duration.ofSeconds(1)),
        Mono.just(BookDto(1, "REACTIVE_Test"))
    ).random()
}
