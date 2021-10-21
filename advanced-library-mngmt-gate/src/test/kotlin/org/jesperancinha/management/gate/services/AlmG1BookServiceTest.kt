package org.jesperancinha.management.gate.services

import com.ninjasquad.springmockk.MockkBean
import io.kotest.matchers.nulls.shouldNotBeNull
import io.kotest.matchers.shouldBe
import io.mockk.every
import io.mockk.mockk
import org.jesperancinha.management.domain.Book
import org.jesperancinha.management.gate.client.WebClient
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ActiveProfiles
import reactor.core.publisher.Mono
import java.time.Duration

@SpringBootTest
@ActiveProfiles("prod")
class AlmG1BookServiceTest(
    @Autowired
    private val almG1BookService: AlmG1BookService
) {

    @MockkBean(relaxed = true)
    lateinit var webClient: WebClient

    @Test
    fun testGetBookByIdTestWhenTimeoutRetrieveSolution() {
        every { webClient.getBookViaReactiveServiceById(100L) } returns Mono.just(100L).then(Mono.just(mockk<Book>())).delayElement(Duration.ofSeconds(5L))
        every { webClient.getBookViaJpaServiceById(100L) } returns Mono.just(Book(0L, "Solution"))

        val bookById = almG1BookService.getBookById(100L)

        bookById.shouldNotBeNull()
        bookById.blockOptional().ifPresent {
                book -> book.name.shouldBe("Solution") }
    }

}