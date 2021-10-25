package org.jesperancinha.management

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication

@SpringBootApplication
open class AdvancedReactiveLibraryService {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            SpringApplication.run(AdvancedReactiveLibraryService::class.java, *args)
        }
    }
}
