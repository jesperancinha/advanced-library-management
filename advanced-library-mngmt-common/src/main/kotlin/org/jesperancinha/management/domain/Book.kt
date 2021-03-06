package org.jesperancinha.management.domain

import org.jesperancinha.management.dtos.SourceType

/**
 * Created by jofisaes on 20/10/2021
 */
open class Book(
    open val id: Long?,
    open val title: String,
    open val source: SourceType,
    open val timestamp: Long,
    open val newField: Boolean?,
) {
    constructor() : this(1L, "", SourceType.REACTIVE, 0, false)
}