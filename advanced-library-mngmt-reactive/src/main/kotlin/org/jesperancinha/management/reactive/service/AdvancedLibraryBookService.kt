package org.jesperancinha.management.reactive.service

import org.jesperancinha.management.dtos.BookDto
import org.jesperancinha.management.reactive.domain.Book
import org.jesperancinha.management.reactive.repository.BookRepository
import org.springframework.stereotype.Service
import reactor.core.publisher.Mono

/**
 * Created by jofisaes on 20/10/2021
 */
@Service
class AdvancedLibraryBookService(
    private val bookRepository: BookRepository,
) {

    fun getBookById(id: Long): Mono<BookDto> {
        return bookRepository.findById(id).map { it.toDto }
    }
}

private val Book.toDto: BookDto
    get() {
        return BookDto(
            id = id,
            title = title
        )
    }
