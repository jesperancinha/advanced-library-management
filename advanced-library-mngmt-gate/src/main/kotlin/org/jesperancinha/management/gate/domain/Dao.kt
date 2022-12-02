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

data class CircuitBreakers(
    val status: String?,
    val details: Map<String, Map<String, Any>>?,
) {
    constructor() : this(null, null)
}

/**
 * Created by jofisaes on 22/10/2021
 */
data class Components(
    val circuitBreakers: CircuitBreakers?
) {
    constructor() : this(null)
}
