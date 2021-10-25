package org.jesperancinha.management.gate.controller

import org.jesperancinha.management.dtos.BookDto
import org.jesperancinha.management.gate.services.AlmG2BookService
import org.springframework.web.bind.annotation.*
import reactor.core.publisher.Mono

/**
 * Created by jofisaes on 20/10/2021
 */
@RestController
@RequestMapping("/books/g2")
class AdvancedLibraryG2Controller(
    private val almG2BookService: AlmG2BookService
) {
    @GetMapping("{id}")
    fun getBookCBById(@PathVariable id: Long): Mono<BookDto> = almG2BookService.getBookCBById(id)

    @PostMapping
    fun createBook(@RequestBody bookDto: BookDto) : Mono<BookDto> = almG2BookService.createBook(bookDto)
}