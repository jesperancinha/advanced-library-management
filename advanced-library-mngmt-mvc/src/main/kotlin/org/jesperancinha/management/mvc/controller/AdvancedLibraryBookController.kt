package org.jesperancinha.management.mvc.controller

import org.jesperancinha.management.dtos.BookDto
import org.jesperancinha.management.mvc.service.AdvancedLibraryBookService
import org.springframework.web.bind.annotation.*

/**
 * Created by jofisaes on 20/10/2021
 */
@RestController
@RequestMapping("books")
class AdvancedLibraryBookController(
    val advancedLibraryBookService: AdvancedLibraryBookService
) {

    @PostMapping("/create")
    fun create(@RequestBody book: BookDto): BookDto {
        return advancedLibraryBookService.save(book)
    }

    @GetMapping("{id}")
    fun getBook(@PathVariable id: Long): BookDto? {
        return advancedLibraryBookService.getBookById(id)
    }
}