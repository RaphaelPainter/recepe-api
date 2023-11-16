package com.rpainter.recepe.api.domain.ports.cook

import com.rpainter.recepe.api.domain.aggregates.ValidatedOrders.cook.CookCreationValidatedOrder
import com.rpainter.recepe.api.domain.model.Cook
import com.rpainter.recepe.api.domain.model.Food


interface IFoodRepository {
    fun findAll(): MutableIterable<Food>
}