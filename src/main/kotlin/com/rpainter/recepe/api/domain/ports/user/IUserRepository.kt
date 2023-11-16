package com.rpainter.recepe.api.domain.ports.user

import com.rpainter.recepe.api.domain.aggregates.ValidatedOrders.admin.AdminCreationValidatedOrder
import com.rpainter.recepe.api.domain.aggregates.ValidatedOrders.user.UserCreationValidatedOrder
import com.rpainter.recepe.api.domain.model.Account
import com.rpainter.recepe.api.domain.model.Food


interface IUserRepository {
    fun findAll(): MutableIterable<Account>
    fun save(userCreationValidatedOrder: UserCreationValidatedOrder): Account
    fun save(adminCreationValidatedOrder: AdminCreationValidatedOrder): Account
}