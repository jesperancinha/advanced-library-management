package org.jesperancinha.management.mvc.service

import org.jesperancinha.management.dtos.BookDto
import org.jesperancinha.management.dtos.SourceType.MVC
import org.jesperancinha.management.mvc.domain.Book
import org.jesperancinha.management.mvc.repository.BookRepository
import org.jesperancinha.management.mvc.repository.findOne
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

    fun save(book: BookDto): BookDto {
        return bookRepository.saveAndFlush(book.toData).toDto
    }
}

private val BookDto.toData: Book
    get() {
        return Book(
            id = id,
            title = title,
            source = MVC
        )
    }

private val Book.toDto: BookDto
    get() {
        return BookDto(
            id = id,
            title = title,
            source = source
        )
    }
