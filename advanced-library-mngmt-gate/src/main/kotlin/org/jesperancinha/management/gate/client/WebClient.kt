package org.jesperancinha.management.gate.client

import org.jesperancinha.management.dtos.BookDto
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Profile
import org.springframework.http.HttpHeaders.CONTENT_TYPE
import org.springframework.http.MediaType.APPLICATION_JSON_VALUE
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.client.WebClient
import org.springframework.web.reactive.function.client.WebClient.create
import org.springframework.web.reactive.function.client.bodyToMono
import reactor.core.publisher.Mono

@Component
@Profile("prod", "docker")
class WebClient(
    @Value("\${org.jesperancinha.management.reactive.host}")
    val reactiveHost: String,
    @Value("\${org.jesperancinha.management.mvc.host}")
    val mvcHost: String
) : WebClientInterface {


    private val webClientReactive: WebClient = create("http://$reactiveHost:8081")
    private val webClientMvc: WebClient = create("http://$mvcHost:8082")

    override fun getBookViaReactiveServiceById(id: Long): Mono<BookDto> = webClientReactive.get()
        .uri("/api/alm/reactive/books/$id").retrieve().bodyToMono()

    override fun getBookViaJpaServiceById(id: Long): Mono<BookDto> = webClientMvc.get()
        .uri("/api/alm/mvc/books/$id").retrieve().bodyToMono()

    override fun sendBookViaReactiveService(bookDto: BookDto): Mono<BookDto> = webClientReactive.post()
        .uri("/api/alm/reactive/books/create")
        .header(CONTENT_TYPE, APPLICATION_JSON_VALUE)
        .body(Mono.just(bookDto), BookDto::class.java)
        .retrieve().bodyToMono()

    override fun sendViaJpaServiceBook(bookDto: BookDto): Mono<BookDto> = webClientMvc.post()
        .uri("/api/alm/mvc/books/create")
        .header(CONTENT_TYPE, APPLICATION_JSON_VALUE)
        .body(Mono.just(bookDto), BookDto::class.java)
        .retrieve().bodyToMono()
}