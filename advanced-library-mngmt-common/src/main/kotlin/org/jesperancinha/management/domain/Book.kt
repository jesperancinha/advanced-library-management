package org.jesperancinha.management.domain

/**
 * Created by jofisaes on 20/10/2021
 */
open class Book(
    open val id: Long,
    open val title: String,
) {
    constructor() : this(1L, "")
}