package com.rpainter.recepe.api.domain.orders

import java.time.Instant
import java.time.LocalDateTime
import java.time.ZoneId

abstract class IOrder {

    val creationDate: LocalDateTime =  LocalDateTime.ofInstant(Instant.now(), ZoneId.of("Europe/Paris"))

    abstract fun validate(): IValidatedOrder

    abstract fun isValid():Boolean
}

