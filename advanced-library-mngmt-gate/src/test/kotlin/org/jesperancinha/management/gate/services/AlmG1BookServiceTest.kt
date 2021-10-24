package org.jesperancinha.management.gate.services

import com.ninjasquad.springmockk.MockkBean
import io.kotest.matchers.nulls.shouldNotBeNull
import io.kotest.matchers.shouldBe
import io.mockk.every
import io.mockk.mockk
import org.jesperancinha.management.domain.Book
import org.jesperancinha.management.gate.client.WebClient
import org.jesperancinha.management.gate.domain.Body
import org.jesperancinha.management.gate.exception.IgnoredException
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
import java.net.URI
import java.time.Duration

@SpringBootTest(webEnvironment = RANDOM_PORT)
@ActiveProfiles("prod")
@DirtiesContext(methodMode = DirtiesContext.MethodMode.BEFORE_METHOD, hierarchyMode = EXHAUSTIVE)
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
    fun testGetBookByIdTestWhenTimeoutRetrieveThenSolution() {
        every { webClient.getBookViaReactiveServiceById(100L) } returns Mono.just(mockk<Book>())
            .delayElement(Duration.ofSeconds(5L))
        every { webClient.getBookViaJpaServiceById(100L) } returns Mono.just(Book(0L, "Solution"))

        val bookById = almG1BookService.getBookById(100L)

        bookById.shouldNotBeNull()
        bookById.blockOptional().ifPresent { book -> book.title.shouldBe("Solution") }
    }

    @Test
    fun testGetBookByIdTestWhenIgnoredExceptionThenNull() {
        every { webClient.getBookViaReactiveServiceById(100L) } returns Mono.error(IgnoredException())
        every { webClient.getBookViaJpaServiceById(100L) } returns Mono.just(Book(0L, "Solution"))

        val bookById = almG1BookService.getBookById(100L)
        repeat(10) {
            val bookById = almG1BookService.getBookCBById(100L)
            bookById.shouldNotBeNull()
            bookById.blockOptional().ifPresent { book ->
                book.title.shouldBe("Solution")
                getCBStatus().shouldBe("UP")
            }
        }
        getCBStatus().shouldBe("UP")

        bookById.shouldNotBeNull()
        bookById.blockOptional().ifPresent { book -> book.title.shouldBe("Solution") }
    }


    private fun getCBStatus(): String {
        val forEntity =
            testRestTemplate.getForEntity<Body>(URI.create("http://localhost:$localPort/api/almg/actuator/health"))
        return forEntity.body?.components?.circuitBreakers?.details?.get(AlmG1BookService.ALMR_TC_1)?.get("status") as String
    }
}
