package com.rpainter.recepe.api.domain.orders.user

import com.rpainter.recepe.api.domain.orders.OrderValidationException
import com.rpainter.recepe.api.domain.orders.IOrder
import com.rpainter.recepe.api.domain.model.Account

class UserCreationOrder() : IOrder() {

    private lateinit var user: Account

    override fun validate(): UserCreationValidatedOrder {
        if(isValid()){
            return UserCreationValidatedOrder(this)
        }else{
            throw OrderValidationException("Problem while validating UserCreationOrder")
        }
    }

    override fun isValid():Boolean{
        return (!this.user.email.equals(null)
            && !this.user.password.equals(null)
            && !this.user.name.equals(null)
                && this.user.getRole().equals(Account.AccountRole.USER))
    }

     fun setUser(user: Account){
        this.user = user
    }

    fun getUser():Account{
        return this.user
    }

}