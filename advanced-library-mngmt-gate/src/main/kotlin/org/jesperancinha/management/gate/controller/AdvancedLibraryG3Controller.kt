package org.jesperancinha.management.gate.controller

import org.jesperancinha.management.dtos.BookDto
import org.jesperancinha.management.gate.services.AlmG3BookService
import org.springframework.web.bind.annotation.*
import reactor.core.publisher.Mono

/**
 * Created by jofisaes on 20/10/2021
 */
@RestController
@RequestMapping("/books/g3")
class AdvancedLibraryG3Controller(
    private val almG3BookService: AlmG3BookService
) {
    @GetMapping("{id}")
    fun getBookCBById(@PathVariable id: Long): Mono<BookDto> = almG3BookService.getBookCBById(id)

    @PostMapping
    fun createBook(@RequestBody bookDto: BookDto) : Mono<BookDto> = almG3BookService.createBook(bookDto)
}