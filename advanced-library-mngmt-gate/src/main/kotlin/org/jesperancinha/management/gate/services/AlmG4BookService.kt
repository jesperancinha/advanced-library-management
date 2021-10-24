package org.jesperancinha.management.gate.services

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker
import mu.KotlinLogging
import org.jesperancinha.management.domain.Book
import org.jesperancinha.management.gate.client.WebClientInterface
import org.springframework.stereotype.Service
import reactor.core.publisher.Mono

/**
 * Created by jofisaes on 20/10/2021
 */
@Service
open class AlmG4BookService(
    private val webClientInterface: WebClientInterface,
) {
    private val logger = KotlinLogging.logger {}

    @CircuitBreaker(name = ALMR_TC4, fallbackMethod = "getBookByIdJPA")
    open fun getBookCBById(id: Long): Mono<Book> =
        webClientInterface.getBookViaReactiveServiceById(id)

    open fun getBookByIdJPA(id: Long, exception: Exception): Mono<Book> {
        logger.info("Current Exception -> {}", exception)
        return webClientInterface.getBookViaJpaServiceById(id)
    }

    companion object {
        const val ALMR_TC4 = "almr_testcase_4"
    }
}
