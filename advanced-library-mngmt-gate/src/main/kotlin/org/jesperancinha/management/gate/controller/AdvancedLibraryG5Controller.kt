package org.jesperancinha.management.gate.controller

import org.jesperancinha.management.dtos.BookDto
import org.jesperancinha.management.gate.services.AlmG5BookService
import org.springframework.web.bind.annotation.*
import reactor.core.publisher.Mono

@RestController
@RequestMapping("/books/g5")
class AdvancedLibraryG5Controller(
    private val almG5BookService: AlmG5BookService
) {
    @GetMapping("{id}")
    fun getBookCBById(@PathVariable id: Long): Mono<BookDto> = almG5BookService.getBookCBById(id)

    @PostMapping
    fun createBook(@RequestBody bookDto: BookDto): Mono<BookDto> = almG5BookService.createBook(bookDto)
}