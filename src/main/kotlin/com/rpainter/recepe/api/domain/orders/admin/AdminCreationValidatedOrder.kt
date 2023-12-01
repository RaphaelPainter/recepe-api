package com.rpainter.recepe.api.domain.orders.admin

import com.rpainter.recepe.api.domain.orders.IValidatedOrder

class AdminCreationValidatedOrder(override val order: AdminCreationOrder) : IValidatedOrder(order){
}