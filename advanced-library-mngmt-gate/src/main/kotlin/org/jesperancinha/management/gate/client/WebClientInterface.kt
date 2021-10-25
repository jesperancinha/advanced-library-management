package org.jesperancinha.management.gate.client

import org.jesperancinha.management.dtos.BookDto
import reactor.core.publisher.Mono

interface WebClientInterface {
    fun getBookViaReactiveServiceById(id: Long): Mono<BookDto>
    fun getBookViaJpaServiceById(id: Long): Mono<BookDto>
    fun sendBookViaReactiveService(bookDto: BookDto): Mono<BookDto>
    fun sendViaJpaServiceBook(bookDto: BookDto): Mono<BookDto>
}
