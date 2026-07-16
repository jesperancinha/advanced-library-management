package org.jesperancinha.management.gate.domain

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

data class Components(
    val circuitBreakers: CircuitBreakers?
) {
    constructor() : this(null)
}
