package org.jesperancinha.management.gate.domain

/**
 * Created by jofisaes on 22/10/2021
 */
data class Components(
    val circuitBreakers: CircuitBreakers?
) {
    constructor() : this(null)
}