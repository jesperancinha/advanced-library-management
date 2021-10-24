package org.jesperancinha.management.gate.services

import com.ninjasquad.springmockk.MockkBean
import io.kotest.matchers.nulls.shouldNotBeNull
import io.kotest.matchers.shouldBe
import io.mockk.every
import kotlinx.coroutines.runBlocking
import org.jesperancinha.management.domain.Book
import org.jesperancinha.management.gate.client.WebClient
import org.jesperancinha.management.gate.domain.Body
import org.jesperancinha.management.gate.exception.ReactiveAccessException
import org.jesperancinha.management.gate.services.AlmG4BookService.Companion.ALMR_TC4
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT
import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.boot.test.web.client.getForEntity
import org.springframework.boot.web.server.LocalServerPort
import org.springframework.test.annotation.DirtiesContext
import org.springframework.test.annotation.DirtiesContext.HierarchyMode.EXHAUSTIVE
import org.springframework.test.context.ActiveProfiles
import reactor.core.publisher.Mono
import java.lang.Thread.sleep
import java.net.URI

/**
 * Gate 1 Test
 *
 */
@SpringBootTest(webEnvironment = RANDOM_PORT)
@ActiveProfiles("prod")
@DirtiesContext(methodMode = DirtiesContext.MethodMode.BEFORE_METHOD, hierarchyMode = EXHAUSTIVE)
class AlmG4bBookStartupServiceTest(
    @Autowired
    private val almG4BookService: AlmG4BookService,
    @LocalServerPort
    private val localPort: Long,
    @Autowired
    private val testRestTemplate: TestRestTemplate,
) {

    @MockkBean(relaxed = true)
    lateinit var webClient: WebClient

    @Test
    fun testGetBookCBByIdTestWhenTimeoutRetrieveSolution() {
        every { webClient.getBookViaReactiveServiceById(100L) } returns Mono.error(ReactiveAccessException())
        every { webClient.getBookViaJpaServiceById(100L) } returns Mono.just(Book(0L, "SolutionOpen"))

        getCBStatus().shouldBe("UP")
        repeat(4) {
            val bookById = almG4BookService.getBookCBById(100L)
            bookById.shouldNotBeNull()
            bookById.blockOptional().ifPresent { book ->
                book.name.shouldBe("SolutionOpen")
            }
        }
        getCBStatus().shouldBe("UP")
        every { webClient.getBookViaReactiveServiceById(100L) } returns Mono.just(Book(0L, "SolutionClosed"))

        runBlocking {
            val bookById = almG4BookService.getBookCBById(100L)
            bookById.shouldNotBeNull()
            bookById.blockOptional().ifPresent { book ->
                book.name.shouldBe("SolutionClosed")
            }
        }
        getCBStatus().shouldBe("CIRCUIT_OPEN")

        repeat(3) {
            val bookById = almG4BookService.getBookCBById(100L)
            bookById.shouldNotBeNull()
            bookById.blockOptional().ifPresent { book ->
                book.name.shouldBe("SolutionOpen")
            }
        }

        getCBStatus().shouldBe("CIRCUIT_OPEN")

        repeat(40) {
            val bookById = almG4BookService.getBookCBById(100L)
            bookById.shouldNotBeNull()
            bookById.blockOptional().ifPresent { book ->
                book.name.shouldBe("SolutionOpen")
            }
        }
        sleep(1000)
        getCBStatus().shouldBe("CIRCUIT_HALF_OPEN")

        every { webClient.getBookViaReactiveServiceById(100L) } returns Mono.error(ReactiveAccessException())

        repeat(4) {
            val bookById = almG4BookService.getBookCBById(100L)
            bookById.shouldNotBeNull()
            bookById.blockOptional().ifPresent { book ->
                book.name.shouldBe("SolutionOpen")
            }
        }
        getCBStatus().shouldBe("CIRCUIT_OPEN")

        runBlocking {
            val bookById = almG4BookService.getBookCBById(100L)
            bookById.shouldNotBeNull()
            bookById.blockOptional().ifPresent { book ->
                book.name.shouldBe("SolutionOpen")
            }
        }

        getCBStatus().shouldBe("CIRCUIT_OPEN")
    }

    private fun getCBStatus(): String {
        val forEntity =
            testRestTemplate.getForEntity<Body>(URI.create("http://localhost:$localPort/api/almg/actuator/health"))
        return forEntity.body?.components?.circuitBreakers?.details?.get(ALMR_TC4)?.get("status") as String
    }
}
