package org.jesperancinha.management.gate.client

import org.jesperancinha.management.domain.Book
import org.jesperancinha.management.dtos.BookDto
import org.springframework.context.annotation.Profile
import org.springframework.stereotype.Component
import reactor.core.publisher.Mono

@Component
@Profile("prod")
class WebClient : WebClientInterface {
    override fun getBookViaReactiveServiceById(id: Long): Mono<BookDto> = Mono.just(BookDto(1, "REACTIVE_Test"))

    override fun getBookViaJpaServiceById(id: Long): Mono<BookDto> = Mono.just(BookDto(1, "JPA_Test"))

    override fun sendBookViaReactiveService(bookDto: BookDto): Mono<BookDto> = Mono.just(BookDto(1, "REACTIVE_Test"))

    override fun sendViaJpaServiceBook(bookDto: BookDto): Mono<BookDto> = Mono.just(BookDto(1, "JPA_Test"))
}