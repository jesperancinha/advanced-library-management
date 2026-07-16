package org.jesperancinha.management.domain

import org.jesperancinha.management.dtos.SourceType

open class Book(
    open val id: Long?,
    open val title: String,
    open val source: SourceType,
    open val timestamp: Long,
    open val newField: Boolean?,
) {
    constructor() : this(1L, "", SourceType.REACTIVE, 0, false)
}