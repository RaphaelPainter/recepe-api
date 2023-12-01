package com.rpainter.recepe.api.domain.ports.cook

import com.rpainter.recepe.api.domain.orders.cook.CookCreationValidatedOrder
import com.rpainter.recepe.api.domain.model.Chef


interface ICookRepository {
    fun findAll(): MutableIterable<Chef>
    fun save(cookCreationValidatedOrder: CookCreationValidatedOrder): Chef
}