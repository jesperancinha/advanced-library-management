package org.jesperancinha.management.reactive.controller

import org.jesperancinha.management.dtos.BookDto
import org.jesperancinha.management.reactive.service.AdvancedLibraryBookService
import org.springframework.web.bind.annotation.*
import reactor.core.publisher.Mono

/**
 * Created by jofisaes on 20/10/2021
 */
@RestController
@RequestMapping("books")
class AdvancedLibraryBookController(
    private val advancedLibraryBookService: AdvancedLibraryBookService
) {

    @PostMapping("/create")
    fun create(@RequestBody book: BookDto): Mono<BookDto> {
        return advancedLibraryBookService.create(book)
    }

    @PutMapping("/update")
    fun update(@RequestBody book: BookDto): Mono<BookDto> {
        return advancedLibraryBookService.save(book)
    }

    @GetMapping("{id}")
    fun getBook(@PathVariable id: Long): Mono<BookDto> {
        return advancedLibraryBookService.getBookById(id)
    }
}