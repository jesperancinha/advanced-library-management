package org.jesperancinha.management.gate.controller

import org.jesperancinha.management.dtos.BookDto
import org.jesperancinha.management.gate.services.AlmG1BookService
import org.springframework.web.bind.annotation.*
import reactor.core.publisher.Mono

@RestController
@RequestMapping("/books/g1")
class AdvancedLibraryG1Controller(
    private val almG1BookService: AlmG1BookService
) {
    @GetMapping("{id}")
    fun getBookCBById(@PathVariable id: Long): Mono<BookDto> = almG1BookService.getBookCBById(id)

    @PostMapping
    fun createBook(@RequestBody bookDto: BookDto): Mono<BookDto> = almG1BookService.createBook(bookDto)
}