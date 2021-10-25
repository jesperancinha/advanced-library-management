package org.jesperancinha.management.gate.controller

import org.jesperancinha.management.dtos.BookDto
import org.jesperancinha.management.gate.services.AlmG4BookService
import org.springframework.web.bind.annotation.*
import reactor.core.publisher.Mono

/**
 * Created by jofisaes on 20/10/2021
 */
@RestController
@RequestMapping("/books/g4")
class AdvancedLibraryG4Controller(
    private val almG4BookService: AlmG4BookService
) {
    @GetMapping("{id}")
    fun getBookCBById(@PathVariable id: Long): Mono<BookDto> = almG4BookService.getBookCBById(id)

    @PostMapping
    fun createBook(@RequestBody bookDto: BookDto): Mono<BookDto> = almG4BookService.createBook(bookDto)
}