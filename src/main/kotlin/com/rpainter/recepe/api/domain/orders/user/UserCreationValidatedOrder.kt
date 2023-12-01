package com.rpainter.recepe.api.domain.orders.user

import com.rpainter.recepe.api.domain.orders.IValidatedOrder
import com.rpainter.recepe.api.domain.orders.user.UserCreationOrder
import com.rpainter.recepe.api.domain.model.Account

class UserCreationValidatedOrder(order: UserCreationOrder) : IValidatedOrder(order){
    fun getUser(): Account{
        return (order as UserCreationOrder).getUser()
    }
}