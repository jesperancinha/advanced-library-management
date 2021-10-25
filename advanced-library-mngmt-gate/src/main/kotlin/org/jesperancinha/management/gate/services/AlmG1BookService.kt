package org.jesperancinha.management.gate.services

import io.github.resilience4j.bulkhead.annotation.Bulkhead
import io.github.resilience4j.circuitbreaker.CallNotPermittedException
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker
import io.github.resilience4j.ratelimiter.annotation.RateLimiter
import io.github.resilience4j.retry.annotation.Retry
import io.github.resilience4j.timelimiter.annotation.TimeLimiter
import mu.KotlinLogging
import org.jesperancinha.management.dtos.BookDto
import org.jesperancinha.management.gate.client.WebClientInterface
import org.jesperancinha.management.gate.exception.IgnoredException
import org.jesperancinha.management.gate.exception.ReactiveAccessException
import org.springframework.stereotype.Service
import reactor.core.publisher.Mono
import java.util.concurrent.TimeoutException

/**
 * Created by jofisaes on 20/10/2021
 */
@Service
open class AlmG1BookService(
    private val webClientInterface: WebClientInterface,
) {

    private val logger = KotlinLogging.logger {}

    @TimeLimiter(name = ALMR_TC_1, fallbackMethod = "getBookByIdJPA")
    @CircuitBreaker(name = ALMR_TC_1, fallbackMethod = "getBookByIdJPA")
    @RateLimiter(name = ALMR_TC_1)
    @Bulkhead(name = ALMR_TC_1)
    @Retry(name = ALMR_TC_1)
    open fun getBookById(id: Long): Mono<BookDto> =
        webClientInterface.getBookViaReactiveServiceById(id)

    @CircuitBreaker(name = ALMR_TC_1, fallbackMethod = "getBookByIdJPA")
    open fun getBookCBById(id: Long): Mono<BookDto> =
        webClientInterface.getBookViaReactiveServiceById(id)

    open fun getBookByIdJPA(id: Long, exception: ReactiveAccessException): Mono<BookDto> {
        logger.info("Current Exception -> {}", exception)
        return webClientInterface.getBookViaJpaServiceById(id)
    }

    open fun getBookByIdJPA(id: Long, exception: CallNotPermittedException): Mono<BookDto> {
        logger.info("Current Exception -> {}", exception)
        return webClientInterface.getBookViaJpaServiceById(id)
    }

    open fun getBookByIdJPA(id: Long, exception: TimeoutException): Mono<BookDto> {
        logger.info("Current Exception -> {}", exception)
        return webClientInterface.getBookViaJpaServiceById(id)
    }

    open fun getBookByIdJPA(id: Long, exception: IgnoredException): Mono<BookDto> {
        logger.info("Current Exception -> {}", exception)
        return webClientInterface.getBookViaJpaServiceById(id)
    }

    @CircuitBreaker(name = ALMR_TC_1, fallbackMethod = "createBookByIdJPA")
    fun createBook(bookDto: BookDto): Mono<BookDto> {
        return webClientInterface.sendBookViaReactiveService(bookDto)
    }

    open fun createBookByIdJPA(bookDto: BookDto, exception: ReactiveAccessException): Mono<BookDto> {
        logger.info("Current Exception -> {}", exception)
        return webClientInterface.sendBookViaReactiveService(bookDto)
    }

    open fun createBookByIdJPA(bookDto: BookDto, exception: CallNotPermittedException): Mono<BookDto> {
        logger.info("Current Exception -> {}", exception)
        return webClientInterface.sendBookViaReactiveService(bookDto)
    }

    open fun createBookByIdJPA(bookDto: BookDto, exception: TimeoutException): Mono<BookDto> {
        logger.info("Current Exception -> {}", exception)
        return webClientInterface.sendBookViaReactiveService(bookDto)
    }

    open fun createBookByIdJPA(bookDto: BookDto, exception: IgnoredException): Mono<BookDto> {
        logger.info("Current Exception -> {}", exception)
        return webClientInterface.sendBookViaReactiveService(bookDto)
    }

    companion object {
        const val ALMR_TC_1 = "almr_testcase_1"
    }
}
