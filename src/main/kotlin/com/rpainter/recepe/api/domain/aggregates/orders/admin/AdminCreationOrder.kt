package com.rpainter.recepe.api.domain.aggregates.orders.admin

import com.rpainter.recepe.api.domain.aggregates.ValidatedOrders.admin.AdminCreationValidatedOrder
import com.rpainter.recepe.api.domain.aggregates.ValidatedOrders.OrderValidationException
import com.rpainter.recepe.api.domain.aggregates.orders.IOrder
import com.rpainter.recepe.api.domain.model.Account

class AdminCreationOrder(): IOrder() {

    private lateinit var user: Account

    override fun validate(): AdminCreationValidatedOrder {
        if(isValid()){
            return AdminCreationValidatedOrder(this)
        }else{
            throw OrderValidationException("Problem while validating AdminCreationOrder")
        }
    }

    override fun isValid():Boolean{
        return (!this.user.email.equals(null)
                && !this.user.password.equals(null)
                && !this.user.name.equals(null)
                && this.user.getRole().equals(Account.AccountRole.ADMIN))
    }

    fun setUser(user: Account){
        this.user = user
    }

    fun getUser():Account{
        return this.user
    }
}