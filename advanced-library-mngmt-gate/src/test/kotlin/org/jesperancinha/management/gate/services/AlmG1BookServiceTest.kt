package org.jesperancinha.management.gate.services

import com.ninjasquad.springmockk.MockkBean
import io.github.resilience4j.circuitbreaker.CircuitBreakerRegistry
import io.kotest.matchers.nulls.shouldNotBeNull
import io.kotest.matchers.shouldBe
import io.mockk.every
import io.mockk.mockk
import kotlinx.coroutines.runBlocking
import org.jesperancinha.management.domain.Book
import org.jesperancinha.management.gate.client.WebClient
import org.jesperancinha.management.gate.domain.Body
import org.jesperancinha.management.gate.exception.ReactiveAccessException
import org.jesperancinha.management.gate.services.AlmG1BookService.Companion.ALMR_TC_1
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT
import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.boot.test.web.client.getForEntity
import org.springframework.boot.web.server.LocalServerPort
import org.springframework.test.context.ActiveProfiles
import reactor.core.publisher.Mono
import java.lang.Thread.sleep
import java.net.URI
import java.time.Duration

@SpringBootTest(webEnvironment = RANDOM_PORT)
@ActiveProfiles("prod")
class AlmG1BookServiceTest(
    @Autowired
    private val almG1BookService: AlmG1BookService,
    @LocalServerPort
    private val localPort: Long,
    @Autowired
    private val testRestTemplate: TestRestTemplate,
) {

    @MockkBean(relaxed = true)
    lateinit var webClient: WebClient

    @Test
    fun testGetBookByIdTestWhenTimeoutRetrieveSolution() {
        every { webClient.getBookViaReactiveServiceById(100L) } returns Mono.just(mockk<Book>())
            .delayElement(Duration.ofSeconds(5L))
        every { webClient.getBookViaJpaServiceById(100L) } returns Mono.just(Book(0L, "Solution"))

        val bookById = almG1BookService.getBookById(100L)

        bookById.shouldNotBeNull()
        bookById.blockOptional().ifPresent { book -> book.name.shouldBe("Solution") }
    }

    @Test
    fun testGetBookCBByIdTestWhenTimeoutRetrieveSolution() {
        val circuitBreaker = CircuitBreakerRegistry.ofDefaults().circuitBreaker("almr_testcase_1")
        every { webClient.getBookViaReactiveServiceById(100L) } returns Mono.error(ReactiveAccessException())
        every { webClient.getBookViaJpaServiceById(100L) } returns Mono.just(Book(0L, "SolutionOpen"))
        getCBStatus().shouldBe("UP")
        repeat(4) {
            val bookById = almG1BookService.getBookCBById(100L)
            bookById.shouldNotBeNull()
            bookById.blockOptional().ifPresent { book ->
                book.name.shouldBe("SolutionOpen")
            }
        }
        every { webClient.getBookViaReactiveServiceById(100L) } returns Mono.just(Book(0L, "SolutionClosed"))

        runBlocking {
            val bookById = almG1BookService.getBookCBById(100L)
            bookById.shouldNotBeNull()
            bookById.blockOptional().ifPresent { book ->
                book.name.shouldBe("SolutionClosed")
            }
        }

        repeat(3) {
            val bookById = almG1BookService.getBookCBById(100L)
            bookById.shouldNotBeNull()
            bookById.blockOptional().ifPresent { book ->
                book.name.shouldBe("SolutionOpen")
            }
        }

        getCBStatus().shouldBe("CIRCUIT_OPEN")

        repeat(40) {
            val bookById = almG1BookService.getBookCBById(100L)
            bookById.shouldNotBeNull()
            bookById.blockOptional().ifPresent { book ->
                book.name.shouldBe("SolutionOpen")
            }
        }
        sleep(1000)
        getCBStatus().shouldBe("CIRCUIT_HALF_OPEN")
        repeat(4) {
            val bookById = almG1BookService.getBookCBById(100L)
            bookById.shouldNotBeNull()
            bookById.blockOptional().ifPresent { book ->
                book.name.shouldBe("SolutionClosed")
            }
        }
        getCBStatus().shouldBe("CIRCUIT_HALF_OPEN")

        runBlocking {
            val bookById = almG1BookService.getBookCBById(100L)
            bookById.shouldNotBeNull()
            bookById.blockOptional().ifPresent { book ->
                book.name.shouldBe("SolutionClosed")
            }
        }

        getCBStatus().shouldBe("UP")
    }

    private fun getCBStatus(): String {
        val forEntity =
            testRestTemplate.getForEntity<Body>(URI.create("http://localhost:$localPort/api/almg/actuator/health"))
       return forEntity.body?.components?.circuitBreakers?.details?.get(ALMR_TC_1)?.get("status") as String
    }
}
