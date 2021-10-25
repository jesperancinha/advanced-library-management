package org.jesperancinha.management.gate.services

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker
import mu.KotlinLogging
import org.jesperancinha.management.dtos.BookDto
import org.jesperancinha.management.gate.client.WebClientInterface
import org.springframework.stereotype.Service
import reactor.core.publisher.Mono

/**
 * Created by jofisaes on 20/10/2021
 */
@Service
open class AlmG2BookService(
    private val webClientInterface: WebClientInterface,
) {

    private val logger = KotlinLogging.logger {}

    @CircuitBreaker(name = ALMR_TC2, fallbackMethod = "getBookByIdJPA")
    open fun getBookCBById(id: Long): Mono<BookDto> =
        webClientInterface.getBookViaReactiveServiceById(id)

    open fun getBookByIdJPA(id: Long, exception: Exception): Mono<BookDto> {
        logger.info("Current Exception -> {}", exception)
        return webClientInterface.getBookViaJpaServiceById(id)
    }

    companion object {
        const val ALMR_TC2 = "almr_testcase_2"
    }
}
