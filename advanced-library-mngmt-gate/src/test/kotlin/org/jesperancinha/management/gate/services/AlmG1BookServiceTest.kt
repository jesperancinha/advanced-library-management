package org.jesperancinha.management.gate.services

import com.ninjasquad.springmockk.MockkBean
import io.kotest.matchers.nulls.shouldNotBeNull
import io.kotest.matchers.shouldBe
import io.mockk.every
import io.mockk.mockk
import kotlinx.coroutines.delay
import org.jesperancinha.management.domain.Book
import org.jesperancinha.management.gate.client.WebClient
import org.jesperancinha.management.gate.exception.ReactiveAccessException
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ActiveProfiles
import reactor.core.publisher.Mono
import java.lang.Thread.sleep
import java.time.Duration

@SpringBootTest
@ActiveProfiles("prod")
class AlmG1BookServiceTest(
    @Autowired
    private val almG1BookService: AlmG1BookService,
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
        every { webClient.getBookViaReactiveServiceById(100L) } returns Mono.error(ReactiveAccessException())
        every { webClient.getBookViaJpaServiceById(100L) } returns Mono.just(Book(0L, "SolutionOpen"))
        repeat(4) {
            val bookById = almG1BookService.getBookCBById(100L)
            bookById.shouldNotBeNull()
            bookById.blockOptional().ifPresent { book ->
                book.name.shouldBe("SolutionOpen")
            }
        }
        every { webClient.getBookViaReactiveServiceById(100L) } returns Mono.just(Book(0L, "SolutionClosed"))

        val bookById = almG1BookService.getBookCBById(100L)
        bookById.shouldNotBeNull()
        bookById.blockOptional().ifPresent { book ->
            book.name.shouldBe("SolutionClosed")
        }

        repeat(3) {
            val bookById = almG1BookService.getBookCBById(100L)
            bookById.shouldNotBeNull()
            bookById.blockOptional().ifPresent { book ->
                book.name.shouldBe("SolutionOpen")
            }
        }
        sleep(1000)
        repeat(2) {
            val bookById = almG1BookService.getBookCBById(100L)
            bookById.shouldNotBeNull()
            bookById.blockOptional().ifPresent { book ->
                book.name.shouldBe("SolutionClosed")
            }
        }
    }
}