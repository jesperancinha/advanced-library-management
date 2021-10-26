package org.jesperancinha.management.gate.services

import io.github.resilience4j.circuitbreaker.CallNotPermittedException
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker
import mu.KotlinLogging
import org.jesperancinha.management.dtos.BookDto
import org.jesperancinha.management.gate.client.WebClientInterface
import org.jesperancinha.management.gate.exception.IgnoredException
import org.jesperancinha.management.gate.exception.ReactiveAccessException
import org.springframework.stereotype.Service
import org.springframework.web.reactive.function.client.WebClientRequestException
import reactor.core.publisher.Mono
import java.util.concurrent.TimeoutException

/**
 * Created by jofisaes on 20/10/2021
 */
@Service
open class AlmG5BookService(
    private val webClientInterface: WebClientInterface,
) {
    private val logger = KotlinLogging.logger {}

    @CircuitBreaker(name = ALMR_TC_5, fallbackMethod = "getBookByIdJPA")
    open fun getBookCBById(id: Long): Mono<BookDto> =
        webClientInterface.getBookViaReactiveServiceById(id)

    open fun getBookByIdJPA(id: Long, exception: WebClientRequestException): Mono<BookDto> {
        logger.info("Current Exception:", exception)
        return webClientInterface.getBookViaJpaServiceById(id)
    }

    open fun getBookByIdJPA(id: Long, exception: ReactiveAccessException): Mono<BookDto> {
        logger.info("Current Exception:", exception)
        return webClientInterface.getBookViaJpaServiceById(id)
    }

    open fun getBookByIdJPA(id: Long, exception: CallNotPermittedException): Mono<BookDto> {
        logger.info("Current Exception:", exception)
        return webClientInterface.getBookViaJpaServiceById(id)
    }

    open fun getBookByIdJPA(id: Long, exception: TimeoutException): Mono<BookDto> {
        logger.info("Current Exception:", exception)
        return webClientInterface.getBookViaJpaServiceById(id)
    }

    open fun getBookByIdJPA(id: Long, exception: IgnoredException): Mono<BookDto> {
        logger.info("Current Exception:", exception)
        return webClientInterface.getBookViaJpaServiceById(id)
    }

    @CircuitBreaker(name = ALMR_TC_5, fallbackMethod = "createBookByIdJPA")
    fun createBook(bookDto: BookDto): Mono<BookDto> {
        return webClientInterface.sendBookViaReactiveService(bookDto)
    }

    open fun createBookByIdJPA(bookDto: BookDto, exception: ReactiveAccessException): Mono<BookDto> {
        logger.info("Current Exception:", exception)
        return webClientInterface.sendViaJpaServiceBook(bookDto)
    }

    open fun createBookByIdJPA(bookDto: BookDto, exception: CallNotPermittedException): Mono<BookDto> {
        logger.info("Current Exception:", exception)
        return webClientInterface.sendViaJpaServiceBook(bookDto)
    }

    open fun createBookByIdJPA(bookDto: BookDto, exception: TimeoutException): Mono<BookDto> {
        logger.info("Current Exception:", exception)
        return webClientInterface.sendViaJpaServiceBook(bookDto)
    }

    open fun createBookByIdJPA(bookDto: BookDto, exception: IgnoredException): Mono<BookDto> {
        logger.info("Current Exception:", exception)
        return webClientInterface.sendViaJpaServiceBook(bookDto)
    }

    companion object {
        const val ALMR_TC_5 = "almr_testcase_5"
    }
}
