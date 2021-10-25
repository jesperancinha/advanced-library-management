package org.jesperancinha.management

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication


@SpringBootApplication
open class AdvancedLibraryGateLauncher {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            SpringApplication.run(AdvancedLibraryGateLauncher::class.java, *args)
        }
    }
}