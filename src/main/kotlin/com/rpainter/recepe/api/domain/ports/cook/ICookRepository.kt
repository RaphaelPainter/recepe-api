package com.rpainter.recepe.api.domain.ports.cook

import com.rpainter.recepe.api.domain.aggregates.ValidatedOrders.cook.CookCreationValidatedOrder
import com.rpainter.recepe.api.domain.model.Cook


interface ICookRepository {
    fun findAll(): MutableIterable<Cook>
    fun save(cookCreationValidatedOrder: CookCreationValidatedOrder): Cook
}