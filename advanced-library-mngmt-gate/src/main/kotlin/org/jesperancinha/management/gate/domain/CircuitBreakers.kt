package org.jesperancinha.management.gate.domain

data class CircuitBreakers(
    val status: String?,
    val details: Map<String, Map<String, Any>>?,
) {
    constructor() : this(null, null)
}
