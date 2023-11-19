package com.rpainter.recepe.api.domain.orders.cook

import com.rpainter.recepe.api.domain.orders.IValidatedOrder

class CookCreationValidatedOrder(override val order: CookCreationOrder) : IValidatedOrder(order)