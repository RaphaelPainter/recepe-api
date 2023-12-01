package com.rpainter.recepe.api.domain.ports.user

import com.rpainter.recepe.api.domain.orders.admin.AdminCreationValidatedOrder
import com.rpainter.recepe.api.domain.orders.user.UserCreationValidatedOrder
import com.rpainter.recepe.api.domain.model.Account


interface IUserRepository {
    fun findAll(): MutableIterable<Account>
    fun save(userCreationValidatedOrder: UserCreationValidatedOrder): Account
    fun save(adminCreationValidatedOrder: AdminCreationValidatedOrder): Account
}