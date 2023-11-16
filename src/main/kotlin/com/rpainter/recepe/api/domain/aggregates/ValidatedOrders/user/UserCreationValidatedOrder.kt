package com.rpainter.recepe.api.domain.aggregates.ValidatedOrders.user

import com.rpainter.recepe.api.domain.aggregates.ValidatedOrders.IValidatedOrder
import com.rpainter.recepe.api.domain.aggregates.orders.user.UserCreationOrder
import com.rpainter.recepe.api.domain.model.Account

class UserCreationValidatedOrder(order: UserCreationOrder) : IValidatedOrder(order){
    fun getUser(): Account{
        return (order as UserCreationOrder).getUser()
    }
}