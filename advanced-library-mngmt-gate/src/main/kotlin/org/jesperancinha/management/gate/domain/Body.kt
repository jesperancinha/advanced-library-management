package org.jesperancinha.management.gate.domain

/**
 * Created by jofisaes on 22/10/2021
 */
data class Body(
    val status: String?,
    val components: Components?
) {
    constructor() : this(null, null)
}
