package org.jesperancinha.management.gate.services

import io.github.resilience4j.bulkhead.annotation.Bulkhead
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker
import io.github.resilience4j.ratelimiter.annotation.RateLimiter
import io.github.resilience4j.timelimiter.annotation.TimeLimiter
import org.jesperancinha.management.domain.Book
import org.springframework.stereotype.Service

/**
 * Created by jofisaes on 20/10/2021
 */
@Service
class AdvancedLibraryGateBookService {

    @TimeLimiter(name = ALMR, fallbackMethod = "getBookByIdJPA")
    @CircuitBreaker(name = ALMR)
    @RateLimiter(name = ALMR)
    @Bulkhead(name = ALMR)
    fun getBookById(id: Long): Book {
        return Book(1,"REACTIVE_Test")
    }

    companion object{
        const val ALMR = "ALMR"
    }

    fun getBookByIdJPA(id: Long): Book {
        return Book(1,"JPA_Test")
    }

}