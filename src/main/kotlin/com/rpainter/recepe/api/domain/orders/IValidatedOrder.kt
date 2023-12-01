package com.rpainter.recepe.api.domain.orders

import com.rpainter.recepe.api.domain.orders.IOrder
import java.time.Instant
import java.time.LocalDateTime
import java.time.ZoneId

abstract class IValidatedOrder(open val order: IOrder)  {
    val validationDate: LocalDateTime =  LocalDateTime.ofInstant(Instant.now(), ZoneId.of("Europe/Paris"))
}

class OrderValidationException(message: String) : Exception(message)
