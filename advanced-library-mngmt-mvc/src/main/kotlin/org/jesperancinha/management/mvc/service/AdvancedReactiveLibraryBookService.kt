package org.jesperancinha.management.reactive.service

import org.jesperancinha.management.dtos.BookDto
import org.jesperancinha.management.mvc.domain.Book
import org.jesperancinha.management.reactive.repository.BookRepository
import org.jesperancinha.management.reactive.repository.findOne
import org.springframework.stereotype.Service

/**
 * Created by jofisaes on 20/10/2021
 */
@Service
class AdvancedLibraryBookService(
    private val bookRepository: BookRepository,
) {

    fun getBookById(id: Long): BookDto? {
        return bookRepository.findOne(id)?.toDto
    }

    fun save(book: Book): BookDto {
        return bookRepository.save(book).toDto
    }
}

private val Book.toDto: BookDto
    get() {
        return BookDto(
            id = id,
            title = title
        )
    }
