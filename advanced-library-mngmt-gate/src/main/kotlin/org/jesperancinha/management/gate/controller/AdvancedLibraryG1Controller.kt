package org.jesperancinha.management.gate.controller

import org.jesperancinha.management.domain.Book
import org.jesperancinha.management.gate.services.AlmG1BookService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Mono

/**
 * Created by jofisaes on 20/10/2021
 */
@RestController
@RequestMapping("/books/g1")
class AdvancedLibraryG1Controller(
    private val almG1BookService: AlmG1BookService,
) {
    @GetMapping("{id}")
    fun getBookCBById(@PathVariable id: Long): Mono<Book> = almG1BookService.getBookCBById(id)
}