package org.jesperancinha.management.gate.services

import io.github.resilience4j.bulkhead.annotation.Bulkhead
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker
import io.github.resilience4j.ratelimiter.annotation.RateLimiter
import io.github.resilience4j.retry.annotation.Retry
import io.github.resilience4j.timelimiter.annotation.TimeLimiter
import mu.KotlinLogging
import org.jesperancinha.management.domain.Book
import org.jesperancinha.management.gate.client.WebClient
import org.springframework.stereotype.Service
import reactor.core.publisher.Mono

/**
 * Created by jofisaes on 20/10/2021
 */
@Service
open class AlmG1BookService(
    private val webClient: WebClient,
) {


    private val logger = KotlinLogging.logger {}

    @TimeLimiter(name = ALMR_TC_1, fallbackMethod = "getBookByIdJPA")
    @CircuitBreaker(name = ALMR_TC_1, fallbackMethod = "getBookByIdJPA")
    @RateLimiter(name = ALMR_TC_1)
    @Bulkhead(name = ALMR_TC_1)
    @Retry(name = ALMR_TC_1)
    open fun getBookById(id: Long): Mono<Book> =
        webClient.getBookViaReactiveServiceById(id)

    @CircuitBreaker(name = ALMR_TC_1, fallbackMethod = "getBookByIdJPA")
    open fun getBookCBById(id: Long): Mono<Book> =
        webClient.getBookViaReactiveServiceById(id)

    open fun getBookByIdJPA(id: Long, exception: Exception): Mono<Book> {
        logger.info("Current Exception -> {}", exception)
        return webClient.getBookViaJpaServiceById(id)
    }


    companion object {
        const val ALMR_TC_1 = "almr_testcase_1"
    }
}
