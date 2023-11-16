package com.rpainter.recepe.api.domain.aggregates.ValidatedOrders.admin

import com.rpainter.recepe.api.domain.aggregates.ValidatedOrders.IValidatedOrder
import com.rpainter.recepe.api.domain.aggregates.orders.admin.AdminCreationOrder

class AdminCreationValidatedOrder(override val order: AdminCreationOrder) : IValidatedOrder(order){
}