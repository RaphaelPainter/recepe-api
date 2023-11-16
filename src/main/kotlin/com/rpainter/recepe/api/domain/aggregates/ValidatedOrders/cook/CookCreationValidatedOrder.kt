package com.rpainter.recepe.api.domain.aggregates.ValidatedOrders.cook

import com.rpainter.recepe.api.domain.aggregates.ValidatedOrders.IValidatedOrder
import com.rpainter.recepe.api.domain.aggregates.orders.cook.CookCreationOrder

class CookCreationValidatedOrder(override val order: CookCreationOrder) : IValidatedOrder(order)